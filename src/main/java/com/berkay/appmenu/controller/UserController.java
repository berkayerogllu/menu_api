package com.berkay.appmenu.controller;

import com.berkay.appmenu.dto.UserChangePasswordDto;
import com.berkay.appmenu.dto.UserChangeUsernameDto;
import com.berkay.appmenu.dto.UserCreateDto;
import com.berkay.appmenu.dto.UserResponseDto;

import java.util.List;

public interface UserController {
    UserResponseDto addUser(UserCreateDto userCreateDto);
    void deleteUser(Long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Long id);
    UserResponseDto changePassword(UserChangePasswordDto dto);
    UserResponseDto changeUsername(UserChangeUsernameDto dto);

}
