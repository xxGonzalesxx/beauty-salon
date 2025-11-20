package com.beautysalon.repository;

import com.beautysalon.entity.SalonService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SalonServiceRepository extends JpaRepository<SalonService, Long> {
    List<SalonService> findByCategory(String category);
    List<SalonService> findByNameContainingIgnoreCase(String name);
}