package com.example.VehicleTypeService.entity;

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
@Table(name = "vehicleTypes")
public class VehicleType {

    @Id
    @ToString.Exclude
    @Builder.Default
    @Column(name = "vehicleType_id", nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "year_of_invention")
    private int yearOfInvention;

}
