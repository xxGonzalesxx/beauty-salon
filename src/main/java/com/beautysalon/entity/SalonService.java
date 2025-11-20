package com.beautysalon.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "services")
@Data
public class SalonService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    private Integer duration; // в минутах

    private String category; // hair, nails, makeup, etc.

    private String photoUrl; // новое поле для картинок услуг

    // Конструкторы
    public SalonService() {}

    public SalonService(String name, String description, BigDecimal price, Integer duration, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.category = category;
    }

    public SalonService(String name, String description, BigDecimal price, Integer duration, String category, String photoUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.category = category;
        this.photoUrl = photoUrl;
    }
}