package org.example.vehicletypesapi.DTOs;

import lombok.Value;
import org.example.vehicletypesapi.entities.VehicleType;

import java.util.UUID;

@Value
public class VehicleTypeResponse {
    UUID id;
    String name;
    int yearOfInvention;

    public static VehicleTypeResponse from(VehicleType vehicleType) {
        return new VehicleTypeResponse(vehicleType.getId(),vehicleType.getName(),vehicleType.getYearOfInvention());
    }
}