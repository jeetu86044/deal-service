package com.demo.dealService.repository;

import com.demo.dealService.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository  extends JpaRepository<Orders, Long> {

    List<Orders> findByUserIdAndDealId(String userId, String dealId);
}
