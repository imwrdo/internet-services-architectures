package org.example.lab_2.entities;


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
    @Column(name = "id",nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "vehicle_brand")
    private String brand;

    @Column(name = "year_of_production")
    private int yearOfProduction;

    @ManyToOne
    @JoinColumn(name = "vehicle_type_id")
    private VehicleType vehicleType;

    public static VehicleBuilder inMemoryBuilder(){
        return new inMemoryBuilder();
    }

    public static class inMemoryBuilder extends VehicleBuilder {
        @Override
        public Vehicle build() {
            if (super.vehicleType == null) {
                throw new IllegalStateException("Vehicle type not set");
            }
            var vehicle = super.build();
            super.vehicleType.getVehicles().add(vehicle);
            return vehicle;
        }
    }

}
