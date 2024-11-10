package org.example.lab_2.sevices.vehicle;


import jakarta.transaction.Transactional;
import org.example.lab_2.entities.Vehicle;
import org.example.lab_2.entities.VehicleType;
import org.example.lab_2.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
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
    public List<Vehicle> findByVehicleType(VehicleType vehicleType) { return vehicleRepository.findByVehicleType(vehicleType);}

    @Override
    public List<Vehicle> findByBrand(String brand) {
        return vehicleRepository.findByBrand(brand);
    }

    @Override
    public List<Vehicle> findByYearOfProduction(int yearOfProduction) {return vehicleRepository.findByYearOfProduction(yearOfProduction);}

    @Override
    public List<Vehicle> findByNameIgnoreCase(String name) {
        return vehicleRepository.findByBrandIgnoreCase(name);
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
