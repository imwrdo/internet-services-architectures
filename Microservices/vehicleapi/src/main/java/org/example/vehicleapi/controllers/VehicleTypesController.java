package org.example.vehicleapi.controllers;

import org.example.vehicleapi.entities.VehicleType;
import org.example.vehicleapi.sevices.vehicle.VehicleService;
import org.example.vehicleapi.sevices.vehicleType.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class VehicleTypesController {
    private final VehicleTypeService vehicleTypeService;

    @Autowired
    public VehicleTypesController(VehicleService vehicleService, VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }


    @PostMapping("/types/{uuid}")
    public ResponseEntity<Void> createVehicleType(@PathVariable UUID uuid){
        try {
            vehicleTypeService.create(uuid);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/types/{uuid}/")
    public ResponseEntity<Void> deleteVehicleType(@PathVariable UUID uuid){
        var vehicleTypeById = vehicleTypeService.findById(uuid);
        if(vehicleTypeById.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        vehicleTypeService.delete(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
