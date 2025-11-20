package com.beautysalon.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppointmentResponse {
    private Long id;
    private LocalDateTime dateTime;
    private String clientName;
    private String masterName;
    private String serviceName;
    private String status;
    private String notes;
}