package com.company.autobase.dao.travel_routesDAO;

import com.company.autobase.model.TravelRoute;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TravelRouteRowMapper implements RowMapper<TravelRoute> {
    @Override
    public TravelRoute mapRow(ResultSet rs, int rowNum) throws SQLException {
        return TravelRoute
                .builder()
                .id(rs.getInt("id"))
                .orderId(rs.getInt("order_id"))
                .driverId(rs.getInt("driver_id"))
                .vehicleId(rs.getInt("vehicle_id"))
                .build();
    }
}
