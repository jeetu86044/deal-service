package com.demo.dealService.resource;

import com.demo.dealService.entity.Deal;
import com.demo.dealService.impl.DealServiceImpl;
import com.demo.dealService.request.ClaimDeal;
import com.demo.dealService.request.CreateDeal;
import com.demo.dealService.request.DealAction;
import com.demo.dealService.request.UpdateDeal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "deal")
@RestController
public class DealResource {

    private final DealServiceImpl dealService;

    public DealResource(DealServiceImpl dealService) {
        this.dealService = dealService;
    }

    @PostMapping
    public Deal createDeal(@RequestBody CreateDeal createDeal){
        return dealService.createDeal(createDeal);
    }

    @PutMapping(path = "{dealId}")
    public void updateDeal(@PathVariable String dealId ,@RequestBody UpdateDeal updateDeal){
        dealService.updateDeal(dealId, updateDeal);
    }


    @PostMapping(path = "{dealId}/{dealAction}")
    public void dealAction(@PathVariable String dealId, @PathVariable DealAction dealAction){
        dealService.dealAction(dealId, dealAction);
    }

    @PostMapping(path = "{dealId}/claim/{userId}")
    public void claimDeal(@PathVariable String dealId, @PathVariable String  userId){
        dealService.claimDeal(dealId, userId);
    }

}
