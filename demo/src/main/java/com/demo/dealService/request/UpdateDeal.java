package com.demo.dealService.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
@Getter
@Setter
public class UpdateDeal {

    private Integer maxQty;

    private LocalDateTime endDate;
}
