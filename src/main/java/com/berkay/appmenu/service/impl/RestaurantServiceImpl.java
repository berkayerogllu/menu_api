package com.berkay.appmenu.service.impl;

import com.berkay.appmenu.dto.RestaurantCreateDto;
import com.berkay.appmenu.dto.RestaurantResponseDto;
import com.berkay.appmenu.dto.RestaurantUpdateFieldDto;
import com.berkay.appmenu.entity.Restaurant;
import com.berkay.appmenu.repository.RestaurantRepository;
import com.berkay.appmenu.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public RestaurantResponseDto addRestaurant(RestaurantCreateDto dto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(dto.getName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setDistrict(dto.getDistrict());
        restaurant.setPhoneNumber(dto.getPhoneNumber());
        restaurant.setWebsite(dto.getWebsite());
        restaurant.setInstagramUrl(dto.getInstagramUrl());

        Restaurant saved = restaurantRepository.save(restaurant);
        return toResponseDto(saved);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public List<RestaurantResponseDto> getAllRestaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantResponseDto getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .map(this::toResponseDto)
                .orElse(null);
    }

    private RestaurantResponseDto toResponseDto(Restaurant entity) {
        RestaurantResponseDto dto = new RestaurantResponseDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setDistrict(entity.getDistrict());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setWebsite(entity.getWebsite());
        dto.setInstagramUrl(entity.getInstagramUrl());
        return dto;
    }
    
    @Override
    public void changeAddress(RestaurantUpdateFieldDto dto) {
        Restaurant restaurant = restaurantRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        restaurant.setAddress(dto.getValue());
        restaurantRepository.save(restaurant);
    }

    @Override
    public void changePhoneNumber(RestaurantUpdateFieldDto dto) {
        Restaurant restaurant = restaurantRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        restaurant.setPhoneNumber(dto.getValue());
        restaurantRepository.save(restaurant);
    }

    @Override
    public void changeWebsite(RestaurantUpdateFieldDto dto) {
        Restaurant restaurant = restaurantRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        restaurant.setWebsite(dto.getValue());
        restaurantRepository.save(restaurant);
    }

    @Override
    public void changeInstagramUrl(RestaurantUpdateFieldDto dto) {
        Restaurant restaurant = restaurantRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        restaurant.setInstagramUrl(dto.getValue());
        restaurantRepository.save(restaurant);
    }

}
