package com.company.autobase.dao.cargo_ordersDAO;

import com.company.autobase.model.CargoOrders;

import java.util.List;

public interface CargoOrdersDao {
    List<CargoOrders> find();
    int update(CargoOrders cargoOrders);

    int save(CargoOrders cargoOrders);

    int delete(CargoOrders cargoOrders);

    int deleteList();

    int[] saveList(List<CargoOrders> cargoOrders);
}
