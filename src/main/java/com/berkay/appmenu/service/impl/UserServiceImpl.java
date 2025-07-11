package com.berkay.appmenu.service.impl;

import com.berkay.appmenu.dto.UserChangePasswordDto;
import com.berkay.appmenu.dto.UserChangeUsernameDto;
import com.berkay.appmenu.dto.UserCreateDto;
import com.berkay.appmenu.dto.UserResponseDto;
import com.berkay.appmenu.entity.User;
import com.berkay.appmenu.repository.UserRepository;
import com.berkay.appmenu.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto addUser(UserCreateDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword()); // Şifrelenmesi lazım, burada sadece örnek.
        user.setEmail(dto.getEmail());

        User savedUser = userRepository.save(user);

        return toResponseDto(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(this::toResponseDto)
                .orElse(null);  // Daha iyi exception handling öneririm
    }

    private UserResponseDto toResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }
    
    @Override
    public UserResponseDto changePassword(UserChangePasswordDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(dto.getOldPassword())) {
            throw new RuntimeException("Old password does not match");
        }

        user.setPassword(dto.getNewPassword()); // Gerçekte hash'lenmeli
        userRepository.save(user);
        return toResponseDto(user);
    }

    @Override
    public UserResponseDto changeUsername(UserChangeUsernameDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(dto.getNewUsername());
        userRepository.save(user);
        return toResponseDto(user);
    }

}
