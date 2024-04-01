package com.company.autobase.dao.vehicleDAO;

import com.company.autobase.model.Vehicle;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class VehicleRowMapper implements RowMapper<Vehicle> {
    @Override
    public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Vehicle
                .builder()
                .id(rs.getInt("id"))
                .modelName(rs.getString("model_name"))
                .vehicleState(rs.getInt("vehicle_state"))
                .underMaintenance(rs.getBoolean("under_maintenance"))
                .producer(rs.getString("producer"))
                .cargoCapacity(rs.getDouble("cargo_capacity"))
                .build();
    }
}
