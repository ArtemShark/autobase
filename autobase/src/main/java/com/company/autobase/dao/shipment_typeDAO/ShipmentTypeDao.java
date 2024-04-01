package com.company.autobase.dao.shipment_typeDAO;

import com.company.autobase.model.ShipmentType;

import java.util.List;

public interface ShipmentTypeDao {

    List<ShipmentType> find();
    int update(ShipmentType shipmentType);

    int save(ShipmentType shipmentType);

    int delete(ShipmentType shipmentType);

    int deleteList();

    int[] saveList(List<ShipmentType> shipmentType);
}
