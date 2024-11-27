package com.example.VehicleTypeService.repositories.vehicleType;

import com.example.VehicleTypeService.entity.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, UUID> {
    List<VehicleType> findAll();
    List<VehicleType> findByNameIgnoreCase(String name);
    Optional<VehicleType> findById(UUID id);
}
