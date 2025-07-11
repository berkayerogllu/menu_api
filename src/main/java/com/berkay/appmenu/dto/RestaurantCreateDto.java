package com.berkay.appmenu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantCreateDto {
    private String name;
    private String address;
    private String district;
    private String phoneNumber;
    private String website;
    private String instagramUrl;
}