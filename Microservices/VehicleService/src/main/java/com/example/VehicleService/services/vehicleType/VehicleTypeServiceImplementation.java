package com.example.VehicleService.services.vehicleType;

import com.example.VehicleService.repositories.VehicleTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Transactional
@Service
public class VehicleTypeServiceImplementation implements VehicleTypeService {
    private final VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    public VehicleTypeServiceImplementation(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    @Override
    public List<com.example.VehicleService.entities.VehicleType> findAll() {
        return vehicleTypeRepository.findAll();
    }

    @Override
    public Optional<com.example.VehicleService.entities.VehicleType> findById(UUID id) {
        return vehicleTypeRepository.findById(id);
    }

    @Override
    public void create(com.example.VehicleService.entities.VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    @Override
    public void update(com.example.VehicleService.entities.VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    @Override
    public void delete(UUID id) {
        vehicleTypeRepository.deleteById(id);
    }


}
