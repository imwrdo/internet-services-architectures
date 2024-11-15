package org.example.vehicleapi.sevices.vehicleType;
import org.example.vehicleapi.entities.VehicleType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleTypeService {
    List<VehicleType> findAll();
    List<VehicleType> findByNameIgnoreCase(String name);
    Optional<VehicleType> findById(UUID id);
    void create(UUID id);
    void update(VehicleType vehicleType);
    void delete(UUID id);
}
