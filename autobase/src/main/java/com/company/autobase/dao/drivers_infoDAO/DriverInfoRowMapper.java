package com.company.autobase.dao.drivers_infoDAO;

import com.company.autobase.model.DriverInfo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DriverInfoRowMapper implements RowMapper<DriverInfo> {
    @Override
    public DriverInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return DriverInfo
                .builder()
                .id(rs.getInt("id"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .payment(rs.getBigDecimal("payment"))
                .driverExperience(rs.getDouble("driver_experience"))
                .build();
    }
}
