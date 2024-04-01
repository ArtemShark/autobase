package com.company.autobase.dao.finished_travel_routesDAO;

import com.company.autobase.model.FinishedTravelRoute;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FinishedTravelRouteRowMapper implements RowMapper<FinishedTravelRoute> {
    @Override
    public FinishedTravelRoute mapRow(ResultSet rs, int rowNum) throws SQLException {
        return FinishedTravelRoute
                .builder()
                .id(rs.getInt("id"))
                .startDate(rs.getDate("start_date"))
                .finishDate(rs.getDate("finish_date"))
                .routeId(rs.getInt("route_id"))
                .build();
    }
}