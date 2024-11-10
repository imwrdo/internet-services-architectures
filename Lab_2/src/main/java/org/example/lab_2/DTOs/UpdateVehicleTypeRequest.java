package org.example.lab_2.DTOs;
import lombok.Value;

@Value
public class UpdateVehicleTypeRequest {
    String name;
    int yearOfInvention;
}
