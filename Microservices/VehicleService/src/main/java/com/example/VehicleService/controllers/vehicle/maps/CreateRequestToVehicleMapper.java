package com.example.VehicleService.controllers.vehicle.maps;


import com.example.VehicleService.entities.Vehicle;
import org.springframework.stereotype.Component;
import java.util.function.Function;

import com.example.VehicleService.controllers.vehicle.DTOs.CreateVehicleRequest;

@Component
public class CreateRequestToVehicleMapper implements Function<CreateVehicleRequest, Vehicle> {
    @Override
    public Vehicle apply(CreateVehicleRequest createVehicleRequest) {
        return Vehicle.builder()
                .brand(createVehicleRequest.getBrand())
                .yearOfManufacture(createVehicleRequest.getYearOfManufacture())
                .build();
    }
}