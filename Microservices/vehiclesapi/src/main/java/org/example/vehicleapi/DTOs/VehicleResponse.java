package org.example.vehicleapi.DTOs;


import org.example.vehicleapi.entities.Vehicle;
import lombok.Value;

import java.util.UUID;

@Value
public class VehicleResponse {
    UUID id;
    String brand;
    int yearOfProduction;
    UUID vehicleType;

    public static VehicleResponse from(Vehicle vehicle){
        return new VehicleResponse(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getYearOfProduction(),
                vehicle.getVehicleType().getId()
        );
    }
}
