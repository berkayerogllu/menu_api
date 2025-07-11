package com.berkay.appmenu.service;

import com.berkay.appmenu.dto.RestaurantCreateDto;
import com.berkay.appmenu.dto.RestaurantResponseDto;
import com.berkay.appmenu.dto.RestaurantUpdateFieldDto;

import java.util.List;

public interface RestaurantService {

    RestaurantResponseDto addRestaurant(RestaurantCreateDto restaurantCreateDto);

    void deleteRestaurant(Long id);

    List<RestaurantResponseDto> getAllRestaurants();

    RestaurantResponseDto getRestaurantById(Long id);
    
    void changeAddress(RestaurantUpdateFieldDto dto);
    
    void changePhoneNumber(RestaurantUpdateFieldDto dto);
    
    void changeWebsite(RestaurantUpdateFieldDto dto);
    
    void changeInstagramUrl(RestaurantUpdateFieldDto dto);

}
