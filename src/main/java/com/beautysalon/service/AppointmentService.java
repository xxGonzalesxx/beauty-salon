package com.beautysalon.service;

import com.beautysalon.entity.Appointment;
import com.beautysalon.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> getAppointmentsByClient(Long clientId) {
        return appointmentRepository.findByClientId(clientId);
    }

    public List<Appointment> getAppointmentsByMaster(Long masterId) {
        return appointmentRepository.findByMasterId(masterId);
    }

    public boolean isTimeSlotAvailable(Long masterId, LocalDateTime dateTime) {
        List<Appointment> conflicts = appointmentRepository.findByMasterAndDateTime(masterId, dateTime);
        return conflicts.isEmpty();
    }

    public Appointment createAppointment(Appointment appointment) {
        if (!isTimeSlotAvailable(appointment.getMaster().getId(), appointment.getDateTime())) {
            throw new RuntimeException("Time slot is not available");
        }
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointmentStatus(Long id, String status) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStatus(status);
        return appointmentRepository.save(appointment);
    }

    public void cancelAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStatus("CANCELLED");
        appointmentRepository.save(appointment);
    }
}