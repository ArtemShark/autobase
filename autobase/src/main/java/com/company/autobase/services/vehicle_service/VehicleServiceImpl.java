package com.company.autobase.services.vehicle_service;
import com.company.autobase.dao.vehicleDAO.VehicleRepository;
import com.company.autobase.model.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    @Override
    public Vehicle save(Vehicle object) {
        return vehicleRepository.save(object);
    }

    @Override
    public Vehicle update(Vehicle object) {
        return vehicleRepository.save(object);
    }

    @Override
    public void delete(Vehicle object) {
        vehicleRepository.delete(object);
    }

    @Override
    public void deleteList() {
        vehicleRepository.deleteAll();
    }

    @Override
    public List<Vehicle> find() {
        return vehicleRepository.findAll();
    }

    @Override
    public List<Vehicle> saveList(List<Vehicle> objectsList) {
        return vehicleRepository.saveAll(objectsList);
    }
}