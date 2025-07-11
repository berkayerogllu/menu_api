package com.berkay.appmenu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String address;

    private String district; // Örnek: Kadıköy, Beşiktaş

    private String phoneNumber;

    private String website; // Opsiyonel

    private String instagramUrl; // Opsiyonel
}
