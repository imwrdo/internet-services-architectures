package com.example.VehicleService.repositories;

import com.example.VehicleService.entities.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, UUID> {
    List<VehicleType> findAll();
    Optional<VehicleType> findById(UUID id);
}
