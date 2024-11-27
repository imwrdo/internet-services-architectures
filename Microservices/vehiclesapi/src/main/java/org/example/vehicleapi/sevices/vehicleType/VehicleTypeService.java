package org.example.vehicleapi.sevices.vehicleType;
import org.example.vehicleapi.entities.VehicleType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleTypeService {
    List<VehicleType> findAll();
    Optional<VehicleType> findById(UUID id);
    void create(VehicleType vehicleType);
    void update(VehicleType vehicleType);
    void delete(UUID id);
}
