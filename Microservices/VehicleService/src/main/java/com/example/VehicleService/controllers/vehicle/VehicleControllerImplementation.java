package com.example.VehicleService.controllers.vehicle;

import com.example.VehicleService.controllers.vehicle.maps.VehicleToResponseMapper;
import com.example.VehicleService.controllers.vehicle.maps.VehiclesToResponseMapper;
import com.example.VehicleService.controllers.vehicle.maps.CreateRequestToVehicleMapper;
import com.example.VehicleService.controllers.vehicle.DTOs.VehicleResponse;
import com.example.VehicleService.controllers.vehicle.DTOs.CreateVehicleRequest;
import com.example.VehicleService.controllers.vehicle.DTOs.UpdateVehicleRequest;
import com.example.VehicleService.services.vehicle.VehicleService;
import com.example.VehicleService.services.vehicleType.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.VehicleService.controllers.vehicle.DTOs.VehiclesResponse;

import java.util.UUID;
import lombok.extern.java.Log;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Log
public class VehicleControllerImplementation implements VehicleController {
    private final VehicleService vehicleService;
    private final VehicleTypeService vehicleTypeService;

    private final VehicleToResponseMapper vehicleToResponseMapper;
    private final VehiclesToResponseMapper vehiclesToResponseMapper;
    private final CreateRequestToVehicleMapper createRequestToVehicleMapper;

    @Autowired
    public VehicleControllerImplementation(VehicleService vehicleService,
                                           VehicleTypeService vehicleTypeService,
                                           VehicleToResponseMapper vehicleToResponseMapper,
                                           VehiclesToResponseMapper vehiclesToResponseMapper,
                                           CreateRequestToVehicleMapper createRequestToVehicleMapper) {
        this.vehicleService = vehicleService;
        this.vehicleTypeService = vehicleTypeService;
        this.vehicleToResponseMapper = vehicleToResponseMapper;
        this.vehiclesToResponseMapper = vehiclesToResponseMapper;
        this.createRequestToVehicleMapper = createRequestToVehicleMapper;
    }
    @Override
    public VehiclesResponse getVehicles() {
        return vehiclesToResponseMapper.apply(vehicleService.findAll());
    }

    @Override
    public VehicleResponse getVehicle(UUID uuid) {
        return vehicleService.findById(uuid)
                .map(vehicleToResponseMapper)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public VehiclesResponse getVehiclesByVehicleType(UUID uuid) {
        var vehicleType = vehicleTypeService.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return vehiclesToResponseMapper.apply(vehicleService.findByVehicleType(vehicleType));
    }

    @Override
    public VehicleResponse createVehicle(UUID uuid, CreateVehicleRequest request) {

        if (request.getBrand() == null || request.getBrand().isEmpty()) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST); }

        if (request.getYearOfManufacture() < 1500) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST);}

        var vehicleType = vehicleTypeService.findById(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var vehicle = createRequestToVehicleMapper.apply(request);
        vehicle.setVehicleType(vehicleType);
        vehicleService.create(vehicle);

        return vehicleToResponseMapper.apply(vehicle);
    }

    @Override
    public VehicleResponse updateVehicle(UUID uuid, UpdateVehicleRequest request) {
        var vehicle = vehicleService.findById(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (request.getBrand() != null) {vehicle.setBrand(request.getBrand());
        }

        if (request.getYearOfManufacture() != null) {
            if (request.getYearOfManufacture() < 1500) {throw new ResponseStatusException(HttpStatus.BAD_REQUEST);}
            vehicle.setYearOfManufacture(request.getYearOfManufacture());
        }

        vehicleService.update(vehicle);

        return vehicleToResponseMapper.apply(vehicle);
    }

    @Override
    public void deleteVehicle(UUID uuid) {
        if (vehicleService.findById(uuid).isEmpty()) {throw new ResponseStatusException(HttpStatus.NOT_FOUND);}

        vehicleService.delete(uuid);
    }
}
