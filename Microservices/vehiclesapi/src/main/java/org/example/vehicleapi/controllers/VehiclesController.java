package org.example.vehicleapi.controllers;

import org.example.vehicleapi.DTOs.CreateVehicleRequest;
import org.example.vehicleapi.DTOs.UpdateVehicleRequest;
import org.example.vehicleapi.DTOs.VehicleResponse;
import org.example.vehicleapi.entities.Vehicle;
import org.example.vehicleapi.sevices.vehicle.VehicleService;
import org.example.vehicleapi.sevices.vehicleType.VehicleTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class VehiclesController {
    private final VehicleService vehicleService;
    private final VehicleTypeService vehicleTypeService;

    public VehiclesController(VehicleService vehicleService, VehicleTypeService vehicleTypeService) {
        this.vehicleService = vehicleService;
        this.vehicleTypeService = vehicleTypeService;
    }

    @GetMapping("/vehicles/")
    public ResponseEntity<List<VehicleResponse>> getVehicles(){
        return new ResponseEntity<>(vehicleService.findAll().stream().map(VehicleResponse::from).toList(), HttpStatus.OK);
    }

    @GetMapping("/vehicles/{uuid}/")
    public ResponseEntity<VehicleResponse> getVehicleType(@PathVariable UUID uuid){
        var vehicle = vehicleService.findById(uuid);

        return vehicle.map(value -> new ResponseEntity<>(VehicleResponse.from(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/types/{uuid}/vehicles/")
    public ResponseEntity<List<VehicleResponse>> getVehiclesFromType(@PathVariable UUID uuid){
        var type = vehicleTypeService.findById(uuid);
        return type.map(vehicleType -> new ResponseEntity<>(vehicleType.getVehicles().stream().map(VehicleResponse::from).toList(),HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/types/{uuid}/vehicles/")
    public ResponseEntity<VehicleResponse> createVehicle(@PathVariable UUID uuid, @RequestBody CreateVehicleRequest request){
        var vehicleType = vehicleTypeService.findById(uuid);

        if(vehicleType.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var newVehicle = Vehicle.builder()
            .brand(request.getBrand())
            .yearOfProduction(request.getYearOfProduction())
            .vehicleType(vehicleType.get())
            .build();

        vehicleService.create(newVehicle);

        return new ResponseEntity<>(VehicleResponse.from(newVehicle), HttpStatus.CREATED);
    }

    @PutMapping("/vehicles/{uuid}/")
    public ResponseEntity<VehicleResponse> updateVehicle(@PathVariable UUID uuid, @RequestBody UpdateVehicleRequest request){
        var vehicleServiceById = vehicleService.findById(uuid);

        if(vehicleServiceById.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        var vehicle = vehicleServiceById.get();
        vehicle.setBrand(request.getBrand());
        vehicle.setYearOfProduction(request.getYearOfProduction());
        vehicleService.update(vehicle);

        return new ResponseEntity<>(VehicleResponse.from(vehicle), HttpStatus.OK);
    }

    @DeleteMapping("/vehicles/{uuid}/")
    public ResponseEntity<Void> deleteVehicle(@PathVariable UUID uuid){
        var vehicle = vehicleService.findById(uuid);
        if(vehicle.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        vehicleService.delete(vehicle.get().getId());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
