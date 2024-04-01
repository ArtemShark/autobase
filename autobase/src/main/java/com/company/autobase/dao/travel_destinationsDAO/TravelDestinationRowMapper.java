package com.company.autobase.dao.travel_destinationsDAO;

import com.company.autobase.model.TravelDestination;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TravelDestinationRowMapper implements RowMapper<TravelDestination> {
    @Override
    public TravelDestination mapRow(ResultSet rs, int rowNum) throws SQLException {
        return TravelDestination
                .builder()
                .id(rs.getInt("id"))
                .travelDistance(rs.getDouble("travel_distance"))
                .destinationCountry(rs.getString("destination_country"))
                .destinationCity(rs.getString("destination_city"))
                .build();
    }
}
