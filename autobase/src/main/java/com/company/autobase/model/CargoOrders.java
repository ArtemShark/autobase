package com.company.autobase.model;

import com.company.autobase.dao.shipment_typeDAO.ShipmentTypeDao;
import com.company.autobase.dao.shipment_typeDAO.ShipmentTypeDaoImpl;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CargoOrders {
    private int id;
    private double totalWeight;
    private long shipmentTypeId;

    @Override
    public String toString() {
        return "  Id: " + id + "\n" +
                "  Shipment Weight: " + totalWeight + "\n" +
                "  Shipment Type Id: " + shipmentTypeId + "\n" +
                "=".repeat(10);
    }
}
