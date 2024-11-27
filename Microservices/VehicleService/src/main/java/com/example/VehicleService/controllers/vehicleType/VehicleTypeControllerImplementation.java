package com.example.VehicleService.controllers.vehicleType;

import com.example.VehicleService.services.vehicleType.VehicleTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
@RestController
public class VehicleTypeControllerImplementation implements VehicleTypeController {

    private final VehicleTypeService vehicleTypeService;


    public VehicleTypeControllerImplementation(VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @Override
    public void createVehicleType(UUID uuid) {
        if(uuid == null){throw new ResponseStatusException(HttpStatus.BAD_REQUEST);}

        if(vehicleTypeService.findById(uuid).isPresent()){throw new ResponseStatusException(HttpStatus.CONFLICT);}

        vehicleTypeService.create(com.example.VehicleService.entities.VehicleType.builder().id(uuid).build());
    }

    @Override
    public void deleteVehicleType(UUID uuid) {

        if(vehicleTypeService.findById(uuid).isEmpty()){throw new ResponseStatusException(HttpStatus.NOT_FOUND);}

        vehicleTypeService.delete(uuid);
    }
}
