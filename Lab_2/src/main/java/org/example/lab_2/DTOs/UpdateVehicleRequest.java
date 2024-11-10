package org.example.lab_2.DTOs;

import lombok.Value;

@Value
public class UpdateVehicleRequest {
    String brand;
    int yearOfProduction;
}
