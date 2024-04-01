package com.company.autobase.dao.cargo_ordersDAO;

import com.company.autobase.model.CargoOrders;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CargoOrdersRowMapper implements RowMapper<CargoOrders> {

    @Override
    public CargoOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CargoOrders
                .builder()
                .id(rs.getInt("id"))
                .totalWeight(rs.getDouble("total_weight"))
                .shipmentTypeId(rs.getInt("shipment_type_id"))
                .build();
    }
}
