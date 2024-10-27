package org.example.lab_2.sevices.vehicleType;


import jakarta.transaction.Transactional;
import org.example.lab_2.entities.VehicleType;
import org.example.lab_2.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<VehicleType> findAll() {
        return vehicleTypeRepository.findAll();
    }

    @Override
    public List<VehicleType> findByNameIgnoreCase(String name) {
        return vehicleTypeRepository.findByNameIgnoreCase(name);
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
