package com.example.VehicleService.controllers.vehicle.DTOs;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class VehiclesResponse {
    List<Vehicle> vehicles;

    @Value
    @Builder
    public static class Vehicle {
        UUID id;
        String brand;
    }
}