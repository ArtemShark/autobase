package com.company.autobase.services.shipment_types_service;

import com.company.autobase.model.ShipmentType;
import com.company.autobase.services.CRUDInterface;

public interface ShipmentTypeService extends CRUDInterface<ShipmentType> {
    ShipmentType findShipmentTypeById(long id);
}
