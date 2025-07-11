package com.berkay.appmenu.service;

import com.berkay.appmenu.dto.UserRestaurantStatusCreateDto;
import com.berkay.appmenu.dto.UserRestaurantStatusResponseDto;

import java.util.List;

public interface UserRestaurantStatusService {

    UserRestaurantStatusResponseDto addStatus(UserRestaurantStatusCreateDto statusCreateDto);

    void deleteStatus(Long id);

    List<UserRestaurantStatusResponseDto> getAllStatuses();

    UserRestaurantStatusResponseDto getStatusById(Long id);
    
   

    void setStatusToVisit(Long userId, Long restaurantId);

    void setStatusVisited(Long userId, Long restaurantId);

    
    

    
   

}
