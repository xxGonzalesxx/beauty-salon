package com.beautysalon.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppointmentRequest {
    private LocalDateTime dateTime;
    private Long clientId;
    private Long masterId;
    private Long serviceId;
    private String notes;
}