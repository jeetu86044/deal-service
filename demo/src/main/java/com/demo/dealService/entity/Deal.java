package com.demo.dealService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Deal {

    private static final int SINGLE_USER_MAX_QTY = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private double price;

    private int maxQty;

    private int soldQty;

    private int singleUserMaxQty = SINGLE_USER_MAX_QTY;

    private boolean dealStarted = true;

    private String dealId;

    @PrePersist
    public void setDealId(){
        this.dealId = UUID.randomUUID().toString();
    }

}
