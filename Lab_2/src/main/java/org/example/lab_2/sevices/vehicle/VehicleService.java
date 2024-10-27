package org.example.lab_2.sevices.vehicle;

import org.example.lab_2.entities.Vehicle;
import org.example.lab_2.entities.VehicleType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleService {
    List<Vehicle> findAll();
    Optional<Vehicle> findById(UUID id);
    List<Vehicle> findByVehicleType(VehicleType vehicleType);
    List<Vehicle> findByBrand(String brand);
    List<Vehicle> findByYearOfProduction(int yearOfProduction);
    List<Vehicle> findByNameIgnoreCase(String name);

    void create(Vehicle vehicle);
    void update(Vehicle vehicle);
    void delete(UUID vehicleId);
}
