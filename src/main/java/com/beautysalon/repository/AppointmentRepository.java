package com.beautysalon.repository;

import com.beautysalon.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByClientId(Long clientId);
    List<Appointment> findByMasterId(Long masterId);

    @Query("SELECT a FROM Appointment a WHERE a.master.id = :masterId AND a.dateTime BETWEEN :start AND :end")
    List<Appointment> findByMasterAndDateTimeBetween(
            @Param("masterId") Long masterId,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    @Query("SELECT a FROM Appointment a WHERE a.master.id = :masterId AND a.dateTime = :dateTime AND a.status != 'CANCELLED'")
    List<Appointment> findByMasterAndDateTime(
            @Param("masterId") Long masterId,
            @Param("dateTime") LocalDateTime dateTime
    );

    List<Appointment> findByStatus(String status);
}