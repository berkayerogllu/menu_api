package com.berkay.appmenu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserChangePasswordDto {
    private Long userId;
    private String oldPassword;
    private String newPassword;
}
