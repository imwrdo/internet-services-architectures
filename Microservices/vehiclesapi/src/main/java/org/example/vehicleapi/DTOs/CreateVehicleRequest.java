package org.example.vehicleapi.DTOs;
import lombok.Value;

@Value
public class CreateVehicleRequest {
    String brand;
    int yearOfProduction;
}
