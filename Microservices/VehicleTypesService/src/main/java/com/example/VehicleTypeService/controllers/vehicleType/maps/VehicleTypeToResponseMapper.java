package com.example.VehicleTypeService.controllers.vehicleType.maps;

import com.example.VehicleTypeService.controllers.vehicleType.DTOs.VehicleTypeResponse;
import com.example.VehicleTypeService.entity.VehicleType;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VehicleTypeToResponseMapper implements Function<VehicleType, VehicleTypeResponse>{
    @Override
    public VehicleTypeResponse apply(VehicleType vehicleType) {
        return VehicleTypeResponse.builder()
                .id(vehicleType.getId())
                .name(vehicleType.getName())
                .yearOfInvention(vehicleType.getYearOfInvention())
                .build();
    }
}
