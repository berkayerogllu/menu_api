package com.berkay.appmenu.controller.impl;

import com.berkay.appmenu.controller.UserRestaurantStatusController;
import com.berkay.appmenu.dto.UserRestaurantStatusCreateDto;
import com.berkay.appmenu.dto.UserRestaurantStatusResponseDto;
import com.berkay.appmenu.service.UserRestaurantStatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-restaurant-status")
public class UserRestaurantStatusControllerImpl implements UserRestaurantStatusController {

    private final UserRestaurantStatusService userRestaurantStatusService;

    public UserRestaurantStatusControllerImpl(UserRestaurantStatusService userRestaurantStatusService) {
        this.userRestaurantStatusService = userRestaurantStatusService;
    }

    @Override
    @PostMapping("/add")
    public UserRestaurantStatusResponseDto addStatus(@RequestBody UserRestaurantStatusCreateDto dto) {
        return userRestaurantStatusService.addStatus(dto);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteStatus(@PathVariable Long id) {
        userRestaurantStatusService.deleteStatus(id);
    }

    @Override
    @GetMapping("/get-all")
    public List<UserRestaurantStatusResponseDto> getAllStatuses() {
        return userRestaurantStatusService.getAllStatuses();
    }

    @Override
    @GetMapping("/get/{id}")
    public UserRestaurantStatusResponseDto getStatusById(@PathVariable Long id) {
        return userRestaurantStatusService.getStatusById(id);
    }
    

    @Override
    @PostMapping("/set-to-visit")
    public void setStatusToVisit(@RequestParam Long userId, @RequestParam Long restaurantId) {
        userRestaurantStatusService.setStatusToVisit(userId, restaurantId);
    }

    @Override
    @PostMapping("/set-visited")
    public void setStatusVisited(@RequestParam Long userId, @RequestParam Long restaurantId) {
        userRestaurantStatusService.setStatusVisited(userId, restaurantId);
    }
    
  


}
