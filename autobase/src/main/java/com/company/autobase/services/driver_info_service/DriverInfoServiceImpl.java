package com.company.autobase.services.driver_info_service;

import com.company.autobase.dao.drivers_infoDAO.DriverInfoRepository;
import com.company.autobase.model.DriverInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverInfoServiceImpl implements DriverInfoService {
    private final DriverInfoRepository driverInfoRepository;

    @Override
    public DriverInfo save(DriverInfo object) {
        return driverInfoRepository.save(object);
    }

    @Override
    public DriverInfo update(DriverInfo object) {
        return driverInfoRepository.save(object);
    }

    @Override
    public void delete(DriverInfo object) {
        driverInfoRepository.delete(object);
    }

    @Override
    public void deleteList() {
        driverInfoRepository.deleteAll();
    }

    @Override
    public List<DriverInfo> find() {
        return driverInfoRepository.findAll();
    }

    @Override
    public List<DriverInfo> saveList(List<DriverInfo> objectsList) {
        return driverInfoRepository.saveAll(objectsList);
    }
}
