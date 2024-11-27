package org.example.vehicleapi;

import jakarta.annotation.PostConstruct;
import org.example.vehicleapi.entities.Vehicle;
import org.example.vehicleapi.entities.VehicleType;
import org.example.vehicleapi.repositories.VehicleRepository;
import org.example.vehicleapi.sevices.vehicle.VehicleService;
import org.example.vehicleapi.sevices.vehicleType.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class Seeder {

    private final VehicleService vs;
    private final VehicleTypeService vts;
    private final Random rand = new Random();

    @Autowired
    public Seeder (VehicleService vs, VehicleTypeService vts) {
        this.vs = vs;
        this.vts = vts;
    }

    @PostConstruct
    public void init() {
        if(!vs.findAll().isEmpty() || !vts.findAll().isEmpty()) {
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

        List<String> vehicleBrands = List.of("BMW", "Boeing", "Santa Cruz","Audi");
        for(int i = 0; i < vehicleBrands.size(); i++) {

            Vehicle vehicle = Vehicle.builder()
                    .id(UUID.nameUUIDFromBytes(vehicleBrands.get(i).getBytes()))
                    .brand(vehicleBrands.get(i))
                    .yearOfProduction(rand.nextInt(2023 - 1980 + 1) + 1980)
                    .vehicleType(vehicleTypes.get(i % vehicleTypes.size()))
                    .build();
            vs.create(vehicle);
        }


    }

}
