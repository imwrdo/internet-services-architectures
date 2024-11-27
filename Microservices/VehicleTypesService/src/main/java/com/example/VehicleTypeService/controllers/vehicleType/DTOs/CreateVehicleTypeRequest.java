package com.example.VehicleTypeService.controllers.vehicleType.DTOs;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateVehicleTypeRequest {
    String name;
    int yearOfInvention;
}
