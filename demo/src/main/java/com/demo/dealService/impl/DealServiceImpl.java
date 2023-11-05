package com.demo.dealService.impl;

import com.demo.dealService.entity.Deal;
import com.demo.dealService.entity.Orders;
import com.demo.dealService.repository.DealRepository;
import com.demo.dealService.repository.OrdersRepository;
import com.demo.dealService.request.CreateDeal;
import com.demo.dealService.request.DealAction;
import com.demo.dealService.request.UpdateDeal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DealServiceImpl {

    private final DealRepository dealRepository;

    private final OrdersRepository ordersRepository;

    public DealServiceImpl(DealRepository dealRepository, OrdersRepository ordersRepository) {
        this.dealRepository = dealRepository;
        this.ordersRepository = ordersRepository;
    }


    @Transactional()
    public Deal createDeal(CreateDeal createDeal){
        Deal deal = new Deal();
        deal.setPrice(createDeal.getPrice());
        deal.setProductId(createDeal.getProductId());
        deal.setStartTime(createDeal.getStartDate());
        deal.setEndTime(createDeal.getEndDate());
        deal.setMaxQty(createDeal.getMaxQty());
        dealRepository.save(deal);
        return deal;
    }

    @Transactional()
    public void updateDeal(String dealId, UpdateDeal updateDeal){
        Deal deal = getDealEntity(dealId);

        if(Objects.nonNull(updateDeal.getEndDate())){
            deal.setEndTime(updateDeal.getEndDate());
        }

        if(Objects.nonNull(updateDeal.getMaxQty())){
            deal.setMaxQty(updateDeal.getMaxQty());

        }
        dealRepository.save(deal);
    }

    @Transactional()
    public void dealAction(String dealId, DealAction action){
        boolean isDealStarted = DealAction.START == action;
        Deal dealEntity = getDealEntity(dealId);
        dealEntity.setDealStarted(isDealStarted);

    }

    @Transactional()
    public void claimDeal(String dealId, String userId){
        Deal dealEntity = getDealEntity(dealId);
        List<Orders> orders = ordersRepository.findByUserIdAndDealId(userId, dealId);



        if(!isDealValid(dealEntity, userId, orders)){
            throw new IllegalArgumentException("Deal is not valid for this user");
        }
        Orders order = new Orders();
        order.setDealId(dealId);
        order.setUserId(userId);
        ordersRepository.save(order);
        dealEntity.setSoldQty(dealEntity.getSoldQty() - 1);
        dealRepository.save(dealEntity);

    }

    private boolean isDealValid(Deal dealEntity, String userId, List<Orders> orders) {

        if(!dealEntity.isDealStarted()){
            return false;
        }

        if(dealEntity.getSingleUserMaxQty() <= orders.size()){
            return false;
        }
        if(dealEntity.getSoldQty() >= dealEntity.getMaxQty()){
            return false;
        }

        if(LocalDateTime.now().isBefore(dealEntity.getStartTime()) ||  LocalDateTime.now().isAfter(dealEntity.getEndTime()))
            return false;
        return true;
    }

    private Deal getDealEntity(String dealId){
        Optional<Deal> dealOptional = dealRepository.findAllByDealId(dealId);

        if(dealOptional.isEmpty()){
            throw new IllegalArgumentException("deal not found");
        }
        return dealOptional.get();
    }
}
