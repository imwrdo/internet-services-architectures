package org.example.vehicletypesapi.DTOs;
import lombok.Value;

@Value
public class CreateVehicleTypeRequest {
    String name;
    int yearOfInvention;
}