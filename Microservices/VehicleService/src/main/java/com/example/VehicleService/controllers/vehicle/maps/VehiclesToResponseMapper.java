package com.example.VehicleService.controllers.vehicle.maps;

import com.example.VehicleService.entities.Vehicle;
import com.example.VehicleService.controllers.vehicle.DTOs.VehiclesResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class VehiclesToResponseMapper implements Function<List<Vehicle>, VehiclesResponse> {

    public VehiclesResponse apply(List<Vehicle> vehicles) {
        return VehiclesResponse.builder()
                .vehicles(vehicles.stream()
                        .map(vehicle ->
                            VehiclesResponse.Vehicle.builder()
                                    .id(vehicle.getId())
                                    .brand(vehicle.getBrand())
                                    .build())
                        .toList()
                ).build();
    }
}
