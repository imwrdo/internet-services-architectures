package com.example.VehicleTypeService.controllers.vehicleType.DTOs;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class VehicleTypesResponse {
    List<VehicleType> vehicleTypes;

    @Value
    @Builder
    public static class VehicleType {
        UUID id;
        String name;
    }
}