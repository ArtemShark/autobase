package com.company.autobase.dao.travel_routesDAO;

import com.company.autobase.AppStarter;
import com.company.autobase.model.TravelRoute;
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
public class TravelRouteDaoImpl implements TravelRouteDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppStarter.class);

    private static final String SELECT_ROUTES = "SELECT * FROM travel_routes";
    private static final String INSERT_ROUTE = "INSERT INTO travel_routes(order_id, driver_id, vehicle_id) VALUES (?, ?, ?)";
    private static final String DELETE_ROUTE = "DELETE FROM travel_routes WHERE id=?";

    private static final String DELETE_ROUTES = "DELETE FROM travel_routes";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<TravelRoute> routeRowMapper;

    @Override
    public List<TravelRoute> find() {
        try {
            return jdbcTemplate.query(SELECT_ROUTES, routeRowMapper);
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return new ArrayList<>();
    }
    @Override
    public int save(TravelRoute travelRoute) {
        try {
            return jdbcTemplate.update(INSERT_ROUTE,
                    travelRoute.getOrderId(),
                    travelRoute.getDriverId(),
                    travelRoute.getVehicleId());

        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }
        return 1;
    }

    @Override
    public int[] saveList(List<TravelRoute> travelRoutes) {
        try {
            return jdbcTemplate.batchUpdate(INSERT_ROUTE, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setLong(1, travelRoutes.get(i).getOrderId());
                    ps.setLong(2, travelRoutes.get(i).getDriverId());
                    ps.setLong(3, travelRoutes.get(i).getVehicleId());
                }

                @Override
                public int getBatchSize() {
                    return travelRoutes.size();
                }
            });
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return new int[0];
    }

    @Override
    public int delete(TravelRoute travelRoute) {
        try {
            return jdbcTemplate.update(DELETE_ROUTE, travelRoute.getId());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

    @Override
    public int deleteList() {
        try {
            return jdbcTemplate.update(DELETE_ROUTES);
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }
}
