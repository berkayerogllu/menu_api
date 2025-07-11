package com.berkay.appmenu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRestaurantStatusResponseDto {
    private Long id;
    private Long userId;
    private Long restaurantId;
    private String status;
}
