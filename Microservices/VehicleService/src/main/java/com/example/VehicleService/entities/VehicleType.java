package com.example.VehicleService.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "vehicleType_id")
    private UUID id = UUID.randomUUID();

    @ToString.Exclude
    @OneToMany(mappedBy = "vehicleType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Vehicle> vehicles = new ArrayList<>();

}
