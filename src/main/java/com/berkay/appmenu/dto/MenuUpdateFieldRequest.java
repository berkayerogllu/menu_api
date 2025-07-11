package com.berkay.appmenu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuUpdateFieldRequest {
    private Long id;
    private String value; // name ve description için kullanılacak
}
