package com.company.autobase.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Builder
@Table(name = "shipment_types")
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_type")
    private String name_type;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "experience")
    private double experience;

    @Override
    public String toString() {
        return "  Id: " + id + "\n" +
                "  Shipment: " + name_type + "\n" +
                "  Cost: " + cost + "$\n" +
                "  Experience: " + experience + "years\n" +
                "-".repeat(10);
    }
}

