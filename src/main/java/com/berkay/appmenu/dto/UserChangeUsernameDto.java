package com.berkay.appmenu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserChangeUsernameDto {
    private Long userId;
    private String newUsername;
}
