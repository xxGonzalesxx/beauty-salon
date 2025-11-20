package com.beautysalon.service;

import com.beautysalon.entity.SalonService;
import com.beautysalon.repository.SalonServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalonServiceService {
    private final SalonServiceRepository salonServiceRepository;

    public List<SalonService> getAllServices() {
        return salonServiceRepository.findAll();
    }

    public Optional<SalonService> getServiceById(Long id) {
        return salonServiceRepository.findById(id);
    }

    public List<SalonService> getServicesByCategory(String category) {
        return salonServiceRepository.findByCategory(category);
    }

    public SalonService saveService(SalonService service) {
        return salonServiceRepository.save(service);
    }

    public void deleteService(Long id) {
        salonServiceRepository.deleteById(id);
    }
}