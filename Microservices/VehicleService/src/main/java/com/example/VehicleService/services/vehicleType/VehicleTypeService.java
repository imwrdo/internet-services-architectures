package com.example.VehicleService.services.vehicleType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleTypeService {
    List<com.example.VehicleService.entities.VehicleType> findAll();
    Optional<com.example.VehicleService.entities.VehicleType> findById(UUID id);
    void create(com.example.VehicleService.entities.VehicleType vehicleType);
    void update(com.example.VehicleService.entities.VehicleType vehicleType);
    void delete(UUID id);
}
