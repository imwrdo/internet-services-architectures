package com.example.VehicleTypeService.controllers.vehicleType.maps;

import com.example.VehicleTypeService.controllers.vehicleType.DTOs.VehicleTypesResponse;
import com.example.VehicleTypeService.entity.VehicleType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
@Component
public class VehicleTypesToResponseMapper implements Function<List<VehicleType>, VehicleTypesResponse>{
    @Override
    public VehicleTypesResponse apply(List<VehicleType> vehicleTypes) {
        return VehicleTypesResponse.builder()
                .vehicleTypes(vehicleTypes.stream()
                        .map(vehicleType -> VehicleTypesResponse.VehicleType.builder()
                                .id(vehicleType.getId())
                                .name(vehicleType.getName())
                                .build())
                        .toList())
                .build();
    }
}
