package org.example.lab_2.sevices.vehicleType;

import org.example.lab_2.entities.VehicleType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleTypeService {
    List<VehicleType> findAll();
    List<VehicleType> findByNameIgnoreCase(String name);
    Optional<VehicleType> findById(UUID id);
    void create(VehicleType vehicleType);
    void update(VehicleType vehicleType);
    void delete(UUID id);
}
