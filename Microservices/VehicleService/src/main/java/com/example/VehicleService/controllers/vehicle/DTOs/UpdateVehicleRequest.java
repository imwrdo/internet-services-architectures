package com.example.VehicleService.controllers.vehicle.DTOs;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateVehicleRequest {
    String brand;
    Integer yearOfManufacture;

}