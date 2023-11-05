package com.demo.dealService.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
@Builder
@Getter
@Setter
public class CreateDeal {

    private String productId;

    private double price;

    private int maxQty;

    @NonNull
    private LocalDateTime startDate;

    @NonNull
    private LocalDateTime endDate;

}
