package org.example.lab_2.DTOs;
import lombok.Value;

@Value
public class CreateVehicleTypeRequest {
    String name;
    int yearOfInvention;
}
