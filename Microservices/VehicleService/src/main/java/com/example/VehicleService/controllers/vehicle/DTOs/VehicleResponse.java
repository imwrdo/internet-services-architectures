package com.example.VehicleService.controllers.vehicle.DTOs;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class VehicleResponse {
    UUID id;
    String brand;
    int yearOfManufacture;
    UUID vehicleTypeId;
}