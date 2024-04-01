package com.company.autobase.dao.shipment_typeDAO;

import com.company.autobase.AppStarter;
import com.company.autobase.model.ShipmentType;
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
public class ShipmentTypeDaoImpl implements ShipmentTypeDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppStarter.class);
    private static final String SELECT_SHIPMENT_TYPES = "SELECT * FROM shipment_types";
    private static final String INSERT_SHIPMENT_TYPE = "INSERT INTO shipment_types(name_type, cost, experience) VALUES (?, ?, ?)";
    private static final String UPDATE_SHIPMENT_TYPE = "UPDATE shipment_types SET name_type=?, cost=?, experience=? WHERE id=?";
    private static final String DELETE_SHIPMENT_TYPE = "DELETE FROM shipment_types WHERE id=?";

    private static final String DELETE_SHIPMENT_TYPES = "DELETE FROM shipment_types";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<ShipmentType> shipmentTypeRowMapper;
    @Override
    public List<ShipmentType> find() {
        try {
            return jdbcTemplate.query(SELECT_SHIPMENT_TYPES, shipmentTypeRowMapper);
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return new ArrayList<>();
    }

    @Override
    public int update(ShipmentType shipmentType) {
        try {
            return jdbcTemplate.update(UPDATE_SHIPMENT_TYPE,
                    shipmentType.getNameType(),
                    shipmentType.getCost(),
                    shipmentType.getExperience());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }
    @Override
    public int save(ShipmentType shipmentType) {
        try {
            return jdbcTemplate.update(INSERT_SHIPMENT_TYPE,
                    shipmentType.getNameType(),
                    shipmentType.getCost(),
                    shipmentType.getExperience());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

    @Override
    public int[] saveList(List<ShipmentType> shipmentType) {
        try {
            return jdbcTemplate.batchUpdate(INSERT_SHIPMENT_TYPE, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1, shipmentType.get(i).getNameType());
                    ps.setBigDecimal(2, shipmentType.get(i).getCost());
                    ps.setDouble(3, shipmentType.get(i).getExperience());
                }

                @Override
                public int getBatchSize() {
                    return shipmentType.size();
                }
            });
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return new int[0];
    }

    @Override
    public int delete(ShipmentType shipmentType) {
        try {
            return jdbcTemplate.update(DELETE_SHIPMENT_TYPE, shipmentType.getId());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

    @Override
    public int deleteList() {
        try {
            return jdbcTemplate.update(DELETE_SHIPMENT_TYPES);
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }
}

