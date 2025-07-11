package com.berkay.appmenu.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MenuUpdatePriceRequest {
    private Long id;
    private BigDecimal price;
}
