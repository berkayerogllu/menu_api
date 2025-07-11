package com.berkay.appmenu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRestaurantStatusCreateDto {
    private Long userId;
    private Long restaurantId;
    private String status; // "TO_VISIT" veya "VISITED"
}
