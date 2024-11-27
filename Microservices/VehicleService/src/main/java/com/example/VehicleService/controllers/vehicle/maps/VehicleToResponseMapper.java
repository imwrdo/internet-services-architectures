package com.example.VehicleService.controllers.vehicle.maps;

import com.example.VehicleService.entities.Vehicle;
import org.springframework.stereotype.Component;
import java.util.function.Function;

import com.example.VehicleService.controllers.vehicle.DTOs.VehicleResponse;
@Component
public class VehicleToResponseMapper implements Function<Vehicle, VehicleResponse> {
    @Override
    public VehicleResponse apply(Vehicle vehicle) {
        return VehicleResponse.builder()
                .id(vehicle.getId())
                .brand(vehicle.getBrand())
                .yearOfManufacture(vehicle.getYearOfManufacture())
                .vehicleTypeId(vehicle.getVehicleType().getId())
                .build();
    }
}
