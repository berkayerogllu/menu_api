package com.berkay.appmenu.controller;

import com.berkay.appmenu.dto.MenuCreateDto;
import com.berkay.appmenu.dto.MenuResponseDto;
import com.berkay.appmenu.dto.MenuUpdateFieldRequest;
import com.berkay.appmenu.dto.MenuUpdatePriceRequest;

import java.util.List;

public interface MenuController {
    MenuResponseDto addMenu(MenuCreateDto dto);
    void deleteMenu(Long id);
    List<MenuResponseDto> getAllMenus();
    MenuResponseDto getMenuById(Long id);
    void updateMenuName(MenuUpdateFieldRequest request);
    void updateMenuDescription(MenuUpdateFieldRequest request);
    void updateMenuPrice(MenuUpdatePriceRequest request);

}
