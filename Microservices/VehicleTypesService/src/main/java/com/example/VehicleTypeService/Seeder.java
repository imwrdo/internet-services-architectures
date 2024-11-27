package com.example.VehicleTypeService;

import com.example.VehicleTypeService.entity.VehicleType;
import com.example.VehicleTypeService.repositories.vehicleType.VehicleTypeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Seeder {
    private final VehicleTypeRepository vt;
    private Random random = new Random(2137);

    @Autowired
    public Seeder(VehicleTypeRepository vtRepository) {
        this.vt = vtRepository;
    }

    @PostConstruct
    public void init() {
        if(!vt.findAll().isEmpty()) {
            return;
        }

        List<VehicleType> vehicleTypes = new ArrayList<>();
        List<String> vehicleTypesNames = List.of("Car", "Plane", "Bike");
        for(int i = 0; i < vehicleTypesNames.size(); i++) {
            VehicleType vehicleType = VehicleType.builder()
                    .id(UUID.nameUUIDFromBytes(vehicleTypesNames.get(i).getBytes()))
                    .name(vehicleTypesNames.get(i))
                    .yearOfInvention(random.nextInt(2023 - 1800 + 1) + 1800)
                    .build();
            vehicleTypes.add(vehicleType);
        }
        vt.saveAll(vehicleTypes);

    }
}
