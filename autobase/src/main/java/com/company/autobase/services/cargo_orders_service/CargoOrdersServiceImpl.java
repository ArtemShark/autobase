package com.company.autobase.services.cargo_orders_service;


import com.company.autobase.dao.cargo_ordersDAO.CargoOrdersRepository;
import com.company.autobase.model.CargoOrders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CargoOrdersServiceImpl implements CargoOrdersService {
    private final CargoOrdersRepository cargoOrdersRepository;

    @Override
    public CargoOrders save(CargoOrders object) {
        return cargoOrdersRepository.save(object);
    }

    @Override
    public CargoOrders update(CargoOrders object) {
        return cargoOrdersRepository.save(object);
    }

    @Override
    public void delete(CargoOrders object) {
        cargoOrdersRepository.delete(object);
    }

    @Override
    public void deleteList() {
        cargoOrdersRepository.deleteAll();
    }

    @Override
    public List<CargoOrders> find() {
        return cargoOrdersRepository.findAll();
    }

    @Override
    public List<CargoOrders> saveList(List<CargoOrders> objectsList) {
        return cargoOrdersRepository.saveAll(objectsList);
    }
}
