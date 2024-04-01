package com.company.autobase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private int id;
    private String  modelName;
    private int vehicleState;
    private boolean underMaintenance;
    private String producer;
    private double cargoCapacity;

    @Override
    public String toString() {
        return "  Id: " + id + "\n" +
                "  Producer: " + producer + "\n" +
                "  Do: " + modelName + "\n" +
                "  Vehicle State: " + vehicleState + "%\n" +
                "  Is Under Maintenance: " + (underMaintenance ? "yes" : "no") + "\n" +
                "  Cargo Capacity: " + cargoCapacity + "kg\n" +
                "=".repeat(10);
    }
}
