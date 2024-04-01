package com.company.autobase.model;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class ShipmentType {
    private int id;
    private String nameType;
    private BigDecimal cost;
    private double experience;

    @Override
    public String toString() {
        return "  Id: " + id + "\n" +
                "  Shipment: " + nameType + "\n" +
                "  Cost per kg: " + cost+ "$\n" +
                "  Needed Experience: " + experience + "years\n" +
                "=".repeat(10);
    }
}
