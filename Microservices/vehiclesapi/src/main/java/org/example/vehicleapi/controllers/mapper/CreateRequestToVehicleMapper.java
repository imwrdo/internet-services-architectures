package org.example.vehicleapi.controllers.mapper;

import org.example.vehicleapi.DTOs.CreateVehicleRequest;
import org.example.vehicleapi.entities.Vehicle;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CreateRequestToVehicleMapper implements Function<CreateVehicleRequest, Vehicle> {

    @Override
    public Vehicle apply(CreateVehicleRequest createVehicleRequest) {
        return Vehicle.builder()
                .brand(createVehicleRequest.getBrand())
                .yearOfProduction(createVehicleRequest.getYearOfProduction())
                .build();
    }
}
