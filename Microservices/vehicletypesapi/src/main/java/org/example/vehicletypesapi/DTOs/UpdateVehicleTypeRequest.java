package org.example.vehicletypesapi.DTOs;
import lombok.Value;

@Value
public class UpdateVehicleTypeRequest {
    String name;
    int yearOfInvention;
}