package org.example.vehicletypesapi;

import jakarta.annotation.PostConstruct;
import org.example.vehicletypesapi.entities.VehicleType;
import org.example.vehicletypesapi.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class Seeder {

    private final VehicleTypeService vts;
    private final Random rand = new Random();

    @Autowired
    public Seeder (VehicleTypeService vts) {
        this.vts = vts;
    }

    @PostConstruct
    public void init() {
        if(!vts.findAll().isEmpty()) {
            return; // something already exists, no need to initialize
        }

        List<VehicleType> vehicleTypes = new ArrayList<>();
        List<String> vehicleTypesNames = List.of("Car", "Plane", "Bike");
        for(int i = 0; i < vehicleTypesNames.size(); i++) {

            VehicleType vehicleType = VehicleType.builder()
                    .id(UUID.nameUUIDFromBytes(vehicleTypesNames.get(i).getBytes()))
                    .name(vehicleTypesNames.get(i))
                    .yearOfInvention(rand.nextInt(2023 - 1800 + 1) + 1800)
                    .hasEngine(i<2)
                    .build();
            vehicleTypes.add(vehicleType);
            vts.create(vehicleType);
        }

    }

}
