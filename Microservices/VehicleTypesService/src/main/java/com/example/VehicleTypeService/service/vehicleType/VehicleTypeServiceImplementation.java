package com.example.VehicleTypeService.service.vehicleType;

import com.example.VehicleTypeService.entity.VehicleType;
import com.example.VehicleTypeService.repositories.event.EventRepository;
import com.example.VehicleTypeService.repositories.vehicleType.VehicleTypeRepository;
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
    private final EventRepository eventRepository;

    @Autowired
    public VehicleTypeServiceImplementation(VehicleTypeRepository vehicleTypeRepository, EventRepository eventRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
        this.eventRepository = eventRepository;
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
        eventRepository.sendCreateVehicleTypeEvent(vehicleType.getId());
    }

    @Override
    public void update(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    @Override
    public void delete(UUID id) {
        vehicleTypeRepository.deleteById(id);
        eventRepository.sendDeleteVehicleTypeEvent(id);
    }


}
