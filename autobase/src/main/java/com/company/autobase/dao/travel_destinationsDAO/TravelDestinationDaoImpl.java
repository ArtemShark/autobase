package com.company.autobase.dao.travel_destinationsDAO;

import com.company.autobase.AppStarter;
import com.company.autobase.model.TravelDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TravelDestinationDaoImpl implements TravelDestinationDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppStarter.class);
    private static final String SELECT_DESTINATIONS = "SELECT * FROM travel_destinations";
    private static final String INSERT_DESTINATION = "INSERT INTO travel_destinations(travel_distance, destination_country, destination_city) VALUES (?, ?, ?)";
    private static final String UPDATE_DESTINATION = "UPDATE travel_destinations SET travel_distance=?, destination_country=?, destination_city=? WHERE id=?";
    private static final String DELETE_DESTINATION = "DELETE FROM travel_destinations WHERE id=?";

    private static final String DELETE_DESTINATIONS = "DELETE FROM travel_destinations";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<TravelDestination> destinationRowMapper;

    @Override
    public List<TravelDestination> find() {
        try {
            return jdbcTemplate.query(SELECT_DESTINATIONS, destinationRowMapper);
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return new ArrayList<>();
    }
    @Override
    public int update(TravelDestination travelDestination) {
        try {
            return jdbcTemplate.update(UPDATE_DESTINATION,
                    travelDestination.getTravelDistance(),
                    travelDestination.getDestinationCountry(),
                    travelDestination.getDestinationCity());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

    @Override
    public int save(TravelDestination travelDestination) {
        try {
            return jdbcTemplate.update(INSERT_DESTINATION,
                    travelDestination.getTravelDistance(),
                    travelDestination.getDestinationCountry(),
                    travelDestination.getDestinationCity());
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

    @Override
    public int[] saveList(List<TravelDestination> travelDestinations) {
        try {
            return jdbcTemplate.batchUpdate(INSERT_DESTINATION, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setDouble(1, travelDestinations.get(i).getTravelDistance());
                    ps.setString(2, travelDestinations.get(i).getDestinationCountry());
                    ps.setString(3, travelDestinations.get(i).getDestinationCity());
                }

                @Override
                public int getBatchSize() {
                    return travelDestinations.size();
                }
            });
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return new int[0];
    }
    @Override
    public int delete(TravelDestination travelDestination) {
        try {
            return jdbcTemplate.update(DELETE_DESTINATION, travelDestination.getId());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

    @Override
    public int deleteList() {
        try {
            return jdbcTemplate.update(DELETE_DESTINATIONS);
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }
}
