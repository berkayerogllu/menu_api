package com.berkay.appmenu.service.impl;

import com.berkay.appmenu.dto.MenuCreateDto;
import com.berkay.appmenu.dto.MenuResponseDto;
import com.berkay.appmenu.dto.MenuUpdateFieldRequest;
import com.berkay.appmenu.dto.MenuUpdatePriceRequest;
import com.berkay.appmenu.entity.Menu;
import com.berkay.appmenu.entity.Restaurant;
import com.berkay.appmenu.repository.MenuRepository;
import com.berkay.appmenu.repository.RestaurantRepository;
import com.berkay.appmenu.service.MenuService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuServiceImpl(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public MenuResponseDto addMenu(MenuCreateDto dto) {
        Menu menu = new Menu();

        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + dto.getRestaurantId()));

        menu.setRestaurant(restaurant);
        menu.setName(dto.getName());
        menu.setDescription(dto.getDescription());
        menu.setPrice(dto.getPrice());
        menu.setUpdatedAt(LocalDateTime.now());

        Menu saved = menuRepository.save(menu);

        return toResponseDto(saved);
    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public List<MenuResponseDto> getAllMenus() {
        return menuRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public MenuResponseDto getMenuById(Long id) {
        return menuRepository.findById(id)
                .map(this::toResponseDto)
                .orElse(null);
    }

    private MenuResponseDto toResponseDto(Menu menu) {
        MenuResponseDto dto = new MenuResponseDto();
        dto.setId(menu.getId());
        dto.setRestaurantId(menu.getRestaurant().getId());
        dto.setName(menu.getName());
        dto.setDescription(menu.getDescription());
        dto.setPrice(menu.getPrice());
        dto.setUpdatedAt(menu.getUpdatedAt());
        return dto;
    }
    
    @Override
    public void updateMenuName(MenuUpdateFieldRequest request) {
        Menu menu = menuRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + request.getId()));
        menu.setName(request.getValue());
        menu.setUpdatedAt(LocalDateTime.now());
        menuRepository.save(menu);
    }

    @Override
    public void updateMenuDescription(MenuUpdateFieldRequest request) {
        Menu menu = menuRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + request.getId()));
        menu.setDescription(request.getValue());
        menu.setUpdatedAt(LocalDateTime.now());
        menuRepository.save(menu);
    }

    @Override
    public void updateMenuPrice(MenuUpdatePriceRequest request) {
        Menu menu = menuRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + request.getId()));
        menu.setPrice(request.getPrice());
        menu.setUpdatedAt(LocalDateTime.now());
        menuRepository.save(menu);
    }

}
