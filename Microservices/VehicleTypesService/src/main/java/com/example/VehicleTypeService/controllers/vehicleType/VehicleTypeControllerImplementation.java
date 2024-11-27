package com.example.VehicleTypeService.controllers.vehicleType;

import com.example.VehicleTypeService.controllers.vehicleType.DTOs.CreateVehicleTypeRequest;
import com.example.VehicleTypeService.controllers.vehicleType.DTOs.VehicleTypeResponse;
import com.example.VehicleTypeService.controllers.vehicleType.DTOs.VehicleTypesResponse;
import com.example.VehicleTypeService.controllers.vehicleType.DTOs.UpdateVehicleTypeRequest;
import com.example.VehicleTypeService.controllers.vehicleType.maps.CreateRequestToVehicleTypeMapper;
import com.example.VehicleTypeService.controllers.vehicleType.maps.VehicleTypesToResponseMapper;
import com.example.VehicleTypeService.controllers.vehicleType.maps.VehicleTypeToResponseMapper;
import com.example.VehicleTypeService.service.vehicleType.VehicleTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
@RestController
public class VehicleTypeControllerImplementation implements VehicleTypeController {

    private final VehicleTypeService vehicleTypeService;

    private final VehicleTypeToResponseMapper vehicleTypeToResponseMapper;
    private final VehicleTypesToResponseMapper vehicleTypesToResponseMapper;
    private final CreateRequestToVehicleTypeMapper createRequestToVehicleTypeMapper;

    public VehicleTypeControllerImplementation(VehicleTypeService vehicleTypeService,
                                               VehicleTypeToResponseMapper vehicleTypeToResponseMapper,
                                               VehicleTypesToResponseMapper vehicleTypesToResponseMapper,
                                               CreateRequestToVehicleTypeMapper createRequestToVehicleTypeMapper) {

        this.vehicleTypeService = vehicleTypeService;
        this.vehicleTypeToResponseMapper = vehicleTypeToResponseMapper;
        this.vehicleTypesToResponseMapper = vehicleTypesToResponseMapper;
        this.createRequestToVehicleTypeMapper = createRequestToVehicleTypeMapper;
    }

    @Override
    public VehicleTypesResponse getVehicleTypes() {
        return vehicleTypesToResponseMapper.apply(vehicleTypeService.findAll());
    }

    @Override
    public VehicleTypeResponse getVehicleType(UUID uuid) {
        return vehicleTypeService.findById(uuid)
                .map(vehicleTypeToResponseMapper)
                .orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public VehicleTypeResponse createVehicleType(CreateVehicleTypeRequest request) {
        if(request.getName() == null || request.getName().isEmpty()){throw new ResponseStatusException(HttpStatus.BAD_REQUEST);}

        if(request.getYearOfInvention() <= 0){throw new ResponseStatusException(HttpStatus.BAD_REQUEST);}

        var vehicleType = createRequestToVehicleTypeMapper.apply(request);
        vehicleTypeService.create(vehicleType);

        return vehicleTypeToResponseMapper.apply(vehicleType);
    }

    @Override
    public VehicleTypeResponse updateVehicleType(UUID uuid, UpdateVehicleTypeRequest request) {
        var vehicleType = vehicleTypeService.findById(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(request.getName() == null || request.getName().isEmpty()){throw new ResponseStatusException(HttpStatus.BAD_REQUEST);}
        if(request.getYearOfInvention() <= 1500){throw new ResponseStatusException(HttpStatus.BAD_REQUEST);}

        vehicleType.setName(request.getName());
        vehicleType.setYearOfInvention(request.getYearOfInvention());

        vehicleTypeService.update(vehicleType);

        return vehicleTypeToResponseMapper.apply(vehicleType);
    }

    @Override
    public void deleteVehicleType(UUID uuid) {
        if(vehicleTypeService.findById(uuid).isEmpty()){throw new ResponseStatusException(HttpStatus.NOT_FOUND);}
        vehicleTypeService.delete(uuid);
    }
}
