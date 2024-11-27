package org.example.vehicleapi.DTOs;

import lombok.Value;

@Value
public class UpdateVehicleRequest {
    String brand;
    int yearOfProduction;
}
