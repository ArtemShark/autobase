package com.company.autobase.dao.finished_travel_routesDAO;

import com.company.autobase.AppStarter;
import com.company.autobase.model.FinishedTravelRoute;
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
public class FinishedTravelRouteDaoImpl implements FinishedTravelRouteDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppStarter.class);
    private static final String SELECT_FINISHED_ROUTES = "SELECT * FROM finished_travel_routes";
    private static final String INSERT_FINISHED_ROUTE = "INSERT INTO finished_travel_routes(start_date, finish_date, route_id) VALUES (?, ?, ?)";
    private static final String UPDATE_FINISHED_ROUTE = "UPDATE finished_travel_routes SET start_date=?, finish_date=? WHERE id=?";
    private static final String DELETE_FINISHED_ROUTE = "DELETE FROM finished_travel_routes WHERE id=?";

    private static final String DELETE_FINISHED_ROUTES = "DELETE FROM finished_travel_routes";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<FinishedTravelRoute> finishedRouteRowMapper;

    @Override
    public List<FinishedTravelRoute> find() {
        try {
            return jdbcTemplate.query(SELECT_FINISHED_ROUTES, finishedRouteRowMapper);
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return new ArrayList<>();
    }

    @Override
    public int[] saveList(List<FinishedTravelRoute> finishedTravelRoutes) {
        try {
            return jdbcTemplate.batchUpdate(INSERT_FINISHED_ROUTE, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setDate(1, finishedTravelRoutes.get(i).getStartDate());
                    ps.setDate(2, finishedTravelRoutes.get(i).getFinishDate());
                    ps.setLong(3, finishedTravelRoutes.get(i).getRouteId());
                }

                @Override
                public int getBatchSize() {
                    return finishedTravelRoutes.size();
                }
            });
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return new int[0];
    }

    @Override
    public int update(FinishedTravelRoute finishedTravelRoute) {
        try {
            return jdbcTemplate.update(UPDATE_FINISHED_ROUTE,
                    finishedTravelRoute.getStartDate(),
                    finishedTravelRoute.getFinishDate(),
                    finishedTravelRoute.getId());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }
    @Override
    public int save(FinishedTravelRoute finishedTravelRoute) {
        try {
            return jdbcTemplate.update(INSERT_FINISHED_ROUTE,
                    finishedTravelRoute.getStartDate(),
                    finishedTravelRoute.getFinishDate(),
                    finishedTravelRoute.getRouteId());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }
    @Override
    public int delete(FinishedTravelRoute finishedTravelRoute) {
        try {
            return jdbcTemplate.update(DELETE_FINISHED_ROUTE, finishedTravelRoute.getId());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

    @Override
    public int deleteList() {
        try {
            return jdbcTemplate.update(DELETE_FINISHED_ROUTES);
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

}
