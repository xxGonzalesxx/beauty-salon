package com.beautysalon.service;

import com.beautysalon.entity.Master;
import com.beautysalon.repository.MasterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MasterService {
    private final MasterRepository masterRepository;

    public List<Master> getAllMasters() {
        return masterRepository.findAll();
    }

    public Optional<Master> getMasterById(Long id) {
        return masterRepository.findById(id);
    }

    public List<Master> getMastersByService(Long serviceId) {
        return masterRepository.findByServiceId(serviceId);
    }

    public Master saveMaster(Master master) {
        return masterRepository.save(master);
    }
}