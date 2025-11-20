package com.beautysalon.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "master_id", nullable = false)
    private Master master;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private SalonService service;

    @Column(nullable = false)
    private String status = "PENDING"; // PENDING, CONFIRMED, COMPLETED, CANCELLED

    private String notes;

    // Конструкторы
    public Appointment() {}

    public Appointment(LocalDateTime dateTime, Client client, Master master, SalonService service) {
        this.dateTime = dateTime;
        this.client = client;
        this.master = master;
        this.service = service;
        this.status = "PENDING";
    }
}