package com.berkay.appmenu.controller;

import com.berkay.appmenu.dto.UserRestaurantStatusCreateDto;
import com.berkay.appmenu.dto.UserRestaurantStatusResponseDto;

import java.util.List;

public interface UserRestaurantStatusController {
    UserRestaurantStatusResponseDto addStatus(UserRestaurantStatusCreateDto dto);
    void deleteStatus(Long id);
    List<UserRestaurantStatusResponseDto> getAllStatuses();
    UserRestaurantStatusResponseDto getStatusById(Long id);

    void setStatusToVisit(Long userId, Long restaurantId);

    void setStatusVisited(Long userId, Long restaurantId);


   

}
