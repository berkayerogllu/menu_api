package com.berkay.appmenu.service.impl;

import com.berkay.appmenu.dto.UserRestaurantStatusCreateDto;
import com.berkay.appmenu.dto.UserRestaurantStatusResponseDto;
import com.berkay.appmenu.entity.Restaurant;
import com.berkay.appmenu.entity.User;
import com.berkay.appmenu.entity.UserRestaurantStatus;
import com.berkay.appmenu.repository.RestaurantRepository;
import com.berkay.appmenu.repository.UserRepository;
import com.berkay.appmenu.repository.UserRestaurantStatusRepository;
import com.berkay.appmenu.service.UserRestaurantStatusService;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import jakarta.transaction.Transactional;

@Service
public class UserRestaurantStatusServiceImpl implements UserRestaurantStatusService {

    private final UserRestaurantStatusRepository statusRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public UserRestaurantStatusServiceImpl(UserRestaurantStatusRepository statusRepository,
                                           UserRepository userRepository,
                                           RestaurantRepository restaurantRepository) {
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public UserRestaurantStatusResponseDto addStatus(UserRestaurantStatusCreateDto dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + dto.getUserId()));

        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + dto.getRestaurantId()));

        UserRestaurantStatus.Status statusEnum;
        try {
            statusEnum = UserRestaurantStatus.Status.valueOf(dto.getStatus());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid status value: " + dto.getStatus());
        }

        UserRestaurantStatus status = new UserRestaurantStatus();
        status.setUser(user);
        status.setRestaurant(restaurant);
        status.setStatus(statusEnum);

        UserRestaurantStatus saved = statusRepository.save(status);

        return toResponseDto(saved);
    }

    @Override
    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }

    @Override
    public List<UserRestaurantStatusResponseDto> getAllStatuses() {
        return statusRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserRestaurantStatusResponseDto getStatusById(Long id) {
        return statusRepository.findById(id)
                .map(this::toResponseDto)
                .orElse(null);
    }

    private UserRestaurantStatusResponseDto toResponseDto(UserRestaurantStatus entity) {
        UserRestaurantStatusResponseDto dto = new UserRestaurantStatusResponseDto();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUser().getId());
        dto.setRestaurantId(entity.getRestaurant().getId());
        dto.setStatus(entity.getStatus().name());
        return dto;
    }
    
    



    @Transactional
    @Override
    public void setStatusToVisit(Long userId, Long restaurantId) {
        setStatus(userId, restaurantId, UserRestaurantStatus.Status.TO_VISIT);
    }

    @Transactional
    @Override
    public void setStatusVisited(Long userId, Long restaurantId) {
        setStatus(userId, restaurantId, UserRestaurantStatus.Status.VISITED);
    }

    private void setStatus(Long userId, Long restaurantId, UserRestaurantStatus.Status newStatus) {
        UserRestaurantStatus status = statusRepository.findByUserIdAndRestaurantId(userId, restaurantId)
                .orElseGet(() -> {
                    User user = userRepository.findById(userId)
                            .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
                    Restaurant restaurant = restaurantRepository.findById(restaurantId)
                            .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));
                    UserRestaurantStatus newStatusEntity = new UserRestaurantStatus();
                    newStatusEntity.setUser(user);
                    newStatusEntity.setRestaurant(restaurant);
                    return newStatusEntity;
                });

        status.setStatus(newStatus);
        statusRepository.save(status);
    }



    
   




}
