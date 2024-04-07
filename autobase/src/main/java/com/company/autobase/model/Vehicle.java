package com.company.autobase.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "vehicles")
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model_name")
    private String model_name;

    @Column(name = "vehicle_state")
    private int vehicle_state;

    @Column(name = "under_maintenance")
    private int under_maintenance;

    @Column(name = "producer")
    private String producer;

    @Column(name = "cargo_capacity")
    private double cargo_capacity;

    @Override
    public String toString() {
        return "  Id: " + id + "\n" +
                "  Producer: " + producer + "\n" +
                "  Do: " + model_name + "\n" +
                "  Vehicle State: " + vehicle_state + "%\n" +
                "  Is Under Maintenance: " + (under_maintenance == 1 ? "yes" : "no") + "\n" +
                "  Cargo Capacity: " + cargo_capacity + " kg\n" +
                "-".repeat(10) + "\n";
    }
}

