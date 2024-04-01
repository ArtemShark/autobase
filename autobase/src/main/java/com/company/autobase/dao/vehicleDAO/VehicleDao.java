package com.company.autobase.dao.vehicleDAO;

import com.company.autobase.model.Vehicle;

import java.util.List;

public interface VehicleDao {
    List<Vehicle> find();
    int update(Vehicle vehicle);

    int save(Vehicle vehicle);

    int delete(Vehicle vehicle);

    int deleteList();
    int[] saveList(List<Vehicle> vehicles);
}
