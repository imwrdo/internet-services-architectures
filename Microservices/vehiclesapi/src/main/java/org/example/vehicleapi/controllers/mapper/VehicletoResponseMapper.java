package org.example.vehicleapi.controllers.mapper;

import org.example.vehicleapi.entities.Vehicle;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VehicletoResponseMapper implements Function<Vehicle, Void> {
    @Override
    public Void apply(Vehicle vehicle) {
        return null;
    }
}
