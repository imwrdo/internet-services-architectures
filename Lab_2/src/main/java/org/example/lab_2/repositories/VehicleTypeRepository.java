package org.example.lab_2.repositories;

import org.example.lab_2.entities.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, UUID> {
    List<VehicleType> findAll();
    List<VehicleType> findByNameIgnoreCase(String name);
    Optional<VehicleType> findById(UUID id);
}
