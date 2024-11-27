package com.example.VehicleService.services.vehicle;

import com.example.VehicleService.entities.Vehicle;
import com.example.VehicleService.entities.VehicleType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleService {
    List<Vehicle> findAll();
    Optional<Vehicle> findById(UUID id);
    List<Vehicle> findByVehicleType(VehicleType vehicleType);
    List<Vehicle> findByYearOfManufacture(int yearOfManufacture);
    List<Vehicle> findByBrandIgnoreCase(String brand);

    void create(Vehicle vehicle);
    void update(Vehicle vehicle);
    void delete(UUID vehicleId);
}
