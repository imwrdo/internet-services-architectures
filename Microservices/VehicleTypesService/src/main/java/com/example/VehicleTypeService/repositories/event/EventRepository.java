package com.example.VehicleTypeService.repositories.event;

import java.util.UUID;

public interface EventRepository {
    void sendCreateVehicleTypeEvent(UUID categoryId);

    void sendDeleteVehicleTypeEvent(UUID categoryId);
}
