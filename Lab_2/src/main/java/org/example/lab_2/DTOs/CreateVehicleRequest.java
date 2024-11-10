package org.example.lab_2.DTOs;
import lombok.Value;

@Value
public class CreateVehicleRequest {
    String brand;
    int yearOfProduction;
}
