package com.example.VehicleService.controllers.vehicleType;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;
public interface VehicleTypeController {

    @PutMapping("/vehicleTypes/{uuid}")
    @ResponseStatus(HttpStatus.CREATED)
    void createVehicleType(@PathVariable UUID uuid);

    @DeleteMapping("/vehicleTypes/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteVehicleType(@PathVariable UUID uuid);
}
