package com.example.VehicleService.repositories;

import com.example.VehicleService.entities.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.VehicleService.entities.VehicleType;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    List<Vehicle> findAll();
    Optional<Vehicle> findById(UUID id);
    List<Vehicle> findByVehicleType(VehicleType vehicleType);
    List<Vehicle> findByYearOfManufacture(int yearOfManufacture);
    List<Vehicle> findByBrandIgnoreCase(String brand);
}
