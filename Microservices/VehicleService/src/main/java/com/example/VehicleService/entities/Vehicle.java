package com.example.VehicleService.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Builder
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @ToString.Exclude
    @Builder.Default
    @Column(name = "vehicle_id", nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "yearOfManufacture")
    private int yearOfManufacture;

    @ManyToOne
    @JoinColumn(name = "vehicletype_id")
    private VehicleType vehicleType;
}
