package org.example.lab_2.DTOs;

import lombok.Value;
import org.example.lab_2.entities.VehicleType;

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
