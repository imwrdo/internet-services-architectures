package org.example.lab_2.repositories;

import org.example.lab_2.entities.Vehicle;
import org.example.lab_2.entities.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    List<Vehicle> findAll();
    Optional<Vehicle> findById(UUID id);
    List<Vehicle> findByVehicleType(VehicleType vehicleType);
    List<Vehicle> findByBrand(String brand);
    List<Vehicle> findByYearOfProduction(int yearOfProduction);
    List<Vehicle> findByBrandIgnoreCase(String name);
}
