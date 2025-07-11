package com.berkay.appmenu.controller.impl;

import com.berkay.appmenu.controller.RestaurantController;
import com.berkay.appmenu.dto.RestaurantCreateDto;
import com.berkay.appmenu.dto.RestaurantResponseDto;
import com.berkay.appmenu.dto.RestaurantUpdateFieldDto;
import com.berkay.appmenu.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantControllerImpl implements RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantControllerImpl(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    @PostMapping("/add")
    public RestaurantResponseDto addRestaurant(@RequestBody RestaurantCreateDto dto) {
        return restaurantService.addRestaurant(dto);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
    }

    @Override
    @GetMapping("/get-all")
    public List<RestaurantResponseDto> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @Override
    @GetMapping("/get/{id}")
    public RestaurantResponseDto getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }
    
    @PutMapping("/change-address")
    @Override
    public void changeAddress(@RequestBody RestaurantUpdateFieldDto dto) {
        restaurantService.changeAddress(dto);
    }

    @PutMapping("/change-phone")
    @Override
    public void changePhoneNumber(@RequestBody RestaurantUpdateFieldDto dto) {
        restaurantService.changePhoneNumber(dto);
    }

    @PutMapping("/change-website")
    @Override
    public void changeWebsite(@RequestBody RestaurantUpdateFieldDto dto) {
        restaurantService.changeWebsite(dto);
    }

    @PutMapping("/change-instagram")
    @Override
    public void changeInstagramUrl(@RequestBody RestaurantUpdateFieldDto dto) {
        restaurantService.changeInstagramUrl(dto);
    }

}
