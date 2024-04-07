package com.company.autobase.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "cargo_orders")
@AllArgsConstructor
@NoArgsConstructor
public class CargoOrders {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_weight")
    private double total_weight;

    @ManyToOne
    @JoinColumn(name = "shipment_type_id", nullable = false)
    private ShipmentType shipmentType;

    @Override
    public String toString() {
        return "  Id: " + id + "\n" +
                "  Total Weight: " + total_weight + "\n" +
                "  Shipment Name Type: " + shipmentType.getName_type() + "\n" +
                "  Cost: " + shipmentType.getCost() + "$\n" +
                "  Experience: " + shipmentType.getExperience() + " years\n" +
                "-".repeat(10);
    }
}
