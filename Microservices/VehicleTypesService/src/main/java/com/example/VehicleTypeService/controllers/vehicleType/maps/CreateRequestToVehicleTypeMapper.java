package com.example.VehicleTypeService.controllers.vehicleType.maps;

import com.example.VehicleTypeService.controllers.vehicleType.DTOs.CreateVehicleTypeRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import com.example.VehicleTypeService.entity.VehicleType;

@Component
public class CreateRequestToVehicleTypeMapper implements Function<CreateVehicleTypeRequest, VehicleType> {
    @Override
    public VehicleType apply(CreateVehicleTypeRequest createVehicleTypeRequest) {
        return VehicleType.builder()
                .name(createVehicleTypeRequest.getName())
                .yearOfInvention(createVehicleTypeRequest.getYearOfInvention())
                .build();
    }
}
