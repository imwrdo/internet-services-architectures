package com.example.VehicleTypeService.controllers.vehicleType.DTOs;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class VehicleTypeResponse {
    UUID id;
    String name;
    int yearOfInvention;
}
