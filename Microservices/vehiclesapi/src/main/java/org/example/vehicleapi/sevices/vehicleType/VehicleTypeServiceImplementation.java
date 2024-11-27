package org.example.vehicleapi.sevices.vehicleType;


import jakarta.transaction.Transactional;
import org.example.vehicleapi.entities.VehicleType;
import org.example.vehicleapi.repositories.VehicleRepository;
import org.example.vehicleapi.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Service
public class VehicleTypeServiceImplementation implements VehicleTypeService {
    private final VehicleTypeRepository vehicleTypeRepository;
    private final VehicleRepository vehicleRepository;
    @Autowired
    public VehicleTypeServiceImplementation(VehicleTypeRepository vehicleTypeRepository, VehicleRepository vehicleRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleType> findAll() {
        return vehicleTypeRepository.findAll();
    }

    @Override
    public Optional<VehicleType> findById(UUID id) {
        return vehicleTypeRepository.findById(id);
    }

    @Override
    public void create(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    @Override
    public void update(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    @Override
    public void delete(UUID id) {
        vehicleTypeRepository.deleteById(id);
    }
}
