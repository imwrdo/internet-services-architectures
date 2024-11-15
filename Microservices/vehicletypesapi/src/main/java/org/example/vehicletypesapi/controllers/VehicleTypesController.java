package org.example.vehicletypesapi.controllers;


import org.example.vehicletypesapi.DTOs.CreateVehicleTypeRequest;
import org.example.vehicletypesapi.DTOs.UpdateVehicleTypeRequest;
import org.example.vehicletypesapi.DTOs.VehicleTypeResponse;
import org.example.vehicletypesapi.entities.VehicleType;
import org.example.vehicletypesapi.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class VehicleTypesController {
    private final VehicleTypeService vehicleTypeService;

    @Autowired
    public VehicleTypesController( VehicleTypeService vehicleTypeService) {
        this.vehicleTypeService = vehicleTypeService;
    }

    @GetMapping("/types/")
    public ResponseEntity<List<VehicleTypeResponse>> getALlVehicleTypes() {
        var vehicleTypes = vehicleTypeService.findAll();

        return new ResponseEntity<>(vehicleTypes.stream().map(VehicleTypeResponse::from).toList(), HttpStatus.OK);
    }

    @GetMapping("/types/{uuid}/")
    public ResponseEntity<VehicleTypeResponse> getVehicleTypeById(@PathVariable UUID uuid){
        var vehicleTypes = vehicleTypeService.findById(uuid);
        if(vehicleTypes.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(VehicleTypeResponse.from(vehicleTypes.get()), HttpStatus.OK);
    }

    @PostMapping("/types/")
    public ResponseEntity<VehicleTypeResponse> createVehicleType(@RequestBody CreateVehicleTypeRequest request){
        var vehicleType = VehicleType.builder()
                .name(request.getName())
                .yearOfInvention(request.getYearOfInvention())
                .build();
        vehicleTypeService.create(vehicleType);

        return new ResponseEntity<>(VehicleTypeResponse.from(vehicleType), HttpStatus.CREATED);
    }

    @PutMapping("/types/{uuid}/")
    public ResponseEntity<VehicleTypeResponse> updateVehicleType(@PathVariable UUID uuid, @RequestBody UpdateVehicleTypeRequest request){
        var vehicleTypeById = vehicleTypeService.findById(uuid);
        if(vehicleTypeById.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        var vehicleType = vehicleTypeById.get();
        vehicleType.setName(request.getName());
        vehicleType.setYearOfInvention(request.getYearOfInvention());
        vehicleTypeService.update(vehicleType);
        return new ResponseEntity<>(VehicleTypeResponse.from(vehicleType), HttpStatus.OK);
    }

    @DeleteMapping("/types/{uuid}/")
    public ResponseEntity<Void> deleteVehicleType(@PathVariable UUID uuid){
        var vehicleTypeById = vehicleTypeService.findById(uuid);
        if(vehicleTypeById.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        vehicleTypeService.delete(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}