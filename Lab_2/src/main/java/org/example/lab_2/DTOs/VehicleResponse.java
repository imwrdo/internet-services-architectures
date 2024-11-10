package org.example.lab_2.DTOs;


import org.example.lab_2.entities.Vehicle;
import lombok.Value;

import java.util.UUID;

@Value
public class VehicleResponse {
    UUID id;
    String brand;
    int yearOfProduction;
    VehicleTypeInVehicleResponse vehicleType;

    @Value
    public static class VehicleTypeInVehicleResponse {
        UUID id;
        String name;
    }

    public static VehicleResponse from(Vehicle vehicle){
        return new VehicleResponse(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getYearOfProduction(),
                new VehicleTypeInVehicleResponse(
                        vehicle.getVehicleType().getId(),
                        vehicle.getVehicleType().getName()));
    }
}
