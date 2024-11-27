package com.example.VehicleService.controllers.vehicle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.VehicleService.controllers.vehicle.DTOs.*;



import java.util.UUID;
public interface VehicleController {
    @GetMapping("/vehicles")
    @ResponseStatus(HttpStatus.OK)
    VehiclesResponse getVehicles();

    @GetMapping("/vehicles/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    VehicleResponse getVehicle(@PathVariable UUID uuid);

    @GetMapping("/vehicleTypes/{uuid}/vehicles")
    @ResponseStatus(HttpStatus.OK)
    VehiclesResponse getVehiclesByVehicleType(@PathVariable UUID uuid);

    @PostMapping("/vehicleTypes/{uuid}/vehicles") // POST here, because we only need to create a new object
    @ResponseStatus(HttpStatus.CREATED)
    VehicleResponse createVehicle(@PathVariable UUID uuid, @RequestBody CreateVehicleRequest request);

    @PatchMapping("/vehicles/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    VehicleResponse updateVehicle(@PathVariable UUID uuid, @RequestBody UpdateVehicleRequest request);

    @DeleteMapping("/vehicles/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteVehicle(@PathVariable UUID uuid);
}