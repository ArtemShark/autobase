package com.company.autobase.dao.cargo_ordersDAO;
import com.company.autobase.AppStarter;
import com.company.autobase.model.CargoOrders;
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
public class CargoOrdersDaoImpl implements CargoOrdersDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppStarter.class);
    private static final String SELECT_ORDERS = "SELECT * FROM cargo_orders";
    private static final String INSERT_ORDERS = "INSERT INTO cargo_orders(total_weight, shipment_type_id) VALUES (?, ?)";
    private static final String UPDATE_ORDERS = "UPDATE cargo_orders SET total_weight=? WHERE id=?";
    private static final String DELETE_ORDER = "DELETE FROM cargo_orders WHERE id=?";

    private static final String DELETE_ORDERS = " DELETE FROM cargo_orders";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<CargoOrders> ordersRowMapper;

    @Override
    public List<CargoOrders> find() {
        try {
            return jdbcTemplate.query(SELECT_ORDERS, ordersRowMapper);
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return new ArrayList<>();
    }
    @Override
    public int update(CargoOrders cargoOrders) {
        try {
            return jdbcTemplate.update(UPDATE_ORDERS,
                    cargoOrders.getTotalWeight(),
                    cargoOrders.getId());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }
    @Override
    public int save(CargoOrders cargoOrders) {
        try {
            return jdbcTemplate.update(INSERT_ORDERS,
                    cargoOrders.getTotalWeight(),
                    cargoOrders.getShipmentTypeId());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

    @Override
    public int[] saveList(List<CargoOrders> cargoOrders) {
        try {
            return jdbcTemplate.batchUpdate(INSERT_ORDERS, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setDouble(1, cargoOrders.get(i).getTotalWeight());
                    ps.setLong(2, cargoOrders.get(i).getShipmentTypeId());
                }

                @Override
                public int getBatchSize() {
                    return cargoOrders.size();
                }
            });
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return new int[0];
    }
    @Override
    public int delete(CargoOrders cargoOrders) {
        try {
            return jdbcTemplate.update(DELETE_ORDER, cargoOrders.getId());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

    @Override
    public int deleteList() {
        try {
            return jdbcTemplate.update(DELETE_ORDERS);
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }
}

