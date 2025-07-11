package com.berkay.appmenu.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class MenuCreateDto {
    private Long restaurantId;
    private String name;
    private String description;
    private BigDecimal price;
}
