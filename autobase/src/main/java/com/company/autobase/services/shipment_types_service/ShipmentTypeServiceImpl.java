package com.company.autobase.services.shipment_types_service;


import com.company.autobase.dao.shipment_typeDAO.ShipmentTypeRepository;
import com.company.autobase.model.ShipmentType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentTypeServiceImpl implements ShipmentTypeService {
    private final ShipmentTypeRepository shipmentTypeRepository;

    @Override
    public ShipmentType save(ShipmentType object) {
        return shipmentTypeRepository.save(object);
    }

    @Override
    public ShipmentType update(ShipmentType object) {
        return shipmentTypeRepository.save(object);
    }

    @Override
    public void delete(ShipmentType object) {
        shipmentTypeRepository.delete(object);
    }

    @Override
    public void deleteList() {
        shipmentTypeRepository.deleteAll();
    }

    @Override
    public List<ShipmentType> find() {
        return shipmentTypeRepository.findAll();
    }

    @Override
    public List<ShipmentType> saveList(List<ShipmentType> objectsList) {
        return shipmentTypeRepository.saveAll(objectsList);
    }

    @Override
    public ShipmentType findShipmentTypeById(long id) {
        return shipmentTypeRepository.findShipmentTypeById(id);
    }
}