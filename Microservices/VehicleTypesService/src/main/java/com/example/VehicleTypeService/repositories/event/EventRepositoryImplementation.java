package com.example.VehicleTypeService.repositories.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class EventRepositoryImplementation implements EventRepository {

    @Qualifier("vehicle-service")
    private final RestTemplate vehicleServiceRestTemplate;

    @Autowired
    public EventRepositoryImplementation(RestTemplate vehicleServiceRestTemplate) {
        this.vehicleServiceRestTemplate = vehicleServiceRestTemplate;
    }

    @Override
    public void sendCreateVehicleTypeEvent(UUID vehicleTypeId) {
        vehicleServiceRestTemplate.put("/vehicleTypes/" + vehicleTypeId, null);
    }

    @Override
    public void sendDeleteVehicleTypeEvent(UUID vehicleTypeId) {
        vehicleServiceRestTemplate.delete("/vehicleTypes/" + vehicleTypeId);
    }
}
