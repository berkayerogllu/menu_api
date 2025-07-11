package com.berkay.appmenu.controller.impl;

import com.berkay.appmenu.controller.UserController;
import com.berkay.appmenu.dto.UserChangePasswordDto;
import com.berkay.appmenu.dto.UserChangeUsernameDto;
import com.berkay.appmenu.dto.UserCreateDto;
import com.berkay.appmenu.dto.UserResponseDto;
import com.berkay.appmenu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping("/add")
    public UserResponseDto addUser(@RequestBody UserCreateDto userCreateDto) {
        return userService.addUser(userCreateDto);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @Override
    @GetMapping("/get-all")
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @GetMapping("/get/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    @PostMapping("/change-password")
    @Override
    public UserResponseDto changePassword(@RequestBody UserChangePasswordDto dto) {
        return userService.changePassword(dto);
    }

    @PostMapping("/change-username")
    @Override
    public UserResponseDto changeUsername(@RequestBody UserChangeUsernameDto dto) {
        return userService.changeUsername(dto);
    }

}
