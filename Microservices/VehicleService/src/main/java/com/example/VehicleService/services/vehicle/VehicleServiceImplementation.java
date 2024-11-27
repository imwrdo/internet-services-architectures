package com.example.VehicleService.services.vehicle;

import com.example.VehicleService.entities.Vehicle;
import com.example.VehicleService.repositories.VehicleRepository;
import com.example.VehicleService.entities.VehicleType;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional // When using database
@Service
public class VehicleServiceImplementation implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImplementation(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> findById(UUID id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public List<Vehicle> findByVehicleType(VehicleType vehicleType) {
        return vehicleRepository.findByVehicleType(vehicleType);
    }

    @Override
    public List<Vehicle> findByYearOfManufacture(int yearOfManufacture) {
        return vehicleRepository.findByYearOfManufacture(yearOfManufacture);
    }

    @Override
    public List<Vehicle> findByBrandIgnoreCase(String brand) {
        return vehicleRepository.findByBrandIgnoreCase(brand);
    }

    @Override
    public void create(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public void update(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Override
    public void delete(UUID vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }

}
