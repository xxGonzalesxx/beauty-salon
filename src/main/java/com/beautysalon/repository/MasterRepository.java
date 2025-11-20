package com.beautysalon.repository;

import com.beautysalon.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MasterRepository extends JpaRepository<Master, Long> {
    List<Master> findBySpecialization(String specialization);

    @Query("SELECT m FROM Master m JOIN m.services s WHERE s.id = :serviceId")
    List<Master> findByServiceId(@Param("serviceId") Long serviceId);
}