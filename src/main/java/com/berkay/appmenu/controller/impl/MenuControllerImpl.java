package com.berkay.appmenu.controller.impl;

import com.berkay.appmenu.controller.MenuController;
import com.berkay.appmenu.dto.MenuCreateDto;
import com.berkay.appmenu.dto.MenuResponseDto;
import com.berkay.appmenu.dto.MenuUpdateFieldRequest;
import com.berkay.appmenu.dto.MenuUpdatePriceRequest;
import com.berkay.appmenu.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuControllerImpl implements MenuController {

    private final MenuService menuService;

    public MenuControllerImpl(MenuService menuService) {
        this.menuService = menuService;
    }

    @Override
    @PostMapping("/add")
    public MenuResponseDto addMenu(@RequestBody MenuCreateDto dto) {
        return menuService.addMenu(dto);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }

    @Override
    @GetMapping("/get-all")
    public List<MenuResponseDto> getAllMenus() {
        return menuService.getAllMenus();
    }

    @Override
    @GetMapping("/get/{id}")
    public MenuResponseDto getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id);
    }
    
    @Override
    @PutMapping("/change-name")
    public void updateMenuName(@RequestBody MenuUpdateFieldRequest request) {
        menuService.updateMenuName(request);
    }

    @Override
    @PutMapping("/change-description")
    public void updateMenuDescription(@RequestBody MenuUpdateFieldRequest request) {
        menuService.updateMenuDescription(request);
    }

    @Override
    @PutMapping("/change-price")
    public void updateMenuPrice(@RequestBody MenuUpdatePriceRequest request) {
        menuService.updateMenuPrice(request);
    }

}
