package com.company.autobase.dao.shipment_typeDAO;

import com.company.autobase.model.ShipmentType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class ShipmentTypeRowMapper implements RowMapper<ShipmentType> {
    @Override
    public ShipmentType mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ShipmentType
                .builder()
                .id(rs.getInt("id"))
                .nameType(rs.getString("name_type"))
                .cost(rs.getBigDecimal("cost"))
                .experience(rs.getDouble("experience"))
                .build();
    }
}