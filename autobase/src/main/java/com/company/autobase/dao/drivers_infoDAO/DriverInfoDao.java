package com.company.autobase.dao.drivers_infoDAO;

import com.company.autobase.model.DriverInfo;

import java.util.List;

public interface DriverInfoDao {

    List<DriverInfo> find();

    int update(DriverInfo driverInfo);
    int save(DriverInfo driverInfo);

    int delete(DriverInfo driverInfo);

    int deleteList();

    int[] saveList(List<DriverInfo> driverInfo);
}
