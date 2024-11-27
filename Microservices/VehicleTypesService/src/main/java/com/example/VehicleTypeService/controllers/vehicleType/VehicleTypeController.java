package com.example.VehicleTypeService.controllers.vehicleType;

import com.example.VehicleTypeService.controllers.vehicleType.DTOs.CreateVehicleTypeRequest;
import com.example.VehicleTypeService.controllers.vehicleType.DTOs.VehicleTypesResponse;
import com.example.VehicleTypeService.controllers.vehicleType.DTOs.UpdateVehicleTypeRequest;
import com.example.VehicleTypeService.controllers.vehicleType.DTOs.VehicleTypeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
public interface VehicleTypeController {
    @GetMapping("/vehicleTypes")
    @ResponseStatus(HttpStatus.OK)
    VehicleTypesResponse getVehicleTypes();

    @GetMapping("/vehicleTypes/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    VehicleTypeResponse getVehicleType(@PathVariable UUID uuid);

    @PutMapping("/vehicleTypes") // PUT here, not POST because if does exist, updates it and all info about it
    @ResponseStatus(HttpStatus.CREATED)
    VehicleTypeResponse createVehicleType(@RequestBody CreateVehicleTypeRequest request);

    @PatchMapping("/vehicleTypes/{uuid}")    // PATCH here, not PUT because it demands that object exists (in content just new values, just a delta of the info stored here)
    @ResponseStatus(HttpStatus.OK)
    VehicleTypeResponse updateVehicleType(@PathVariable UUID uuid, @RequestBody UpdateVehicleTypeRequest request);

    @DeleteMapping("/vehicleTypes/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteVehicleType(@PathVariable UUID uuid);
}
