package com.company.autobase.dao.vehicleDAO;

import com.company.autobase.AppStarter;
import com.company.autobase.model.Vehicle;
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
public class VehicleDaoImpl implements VehicleDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppStarter.class);
    private static final String SELECT_VEHICLES = "SELECT * FROM vehicles";
    private static final String INSERT_VEHICLE = "INSERT INTO vehicles(model_name, vehicle_state, under_maintenance, producer, cargo_capacity) VALUES (?, ?, '0', ?, ?)";
    private static final String UPDATE_VEHICLE = "UPDATE vehicles SET model_name=?, vehicle_state=?, under_maintenance=?, producer=?, cargo_capacity=? WHERE id=?";
    private static final String DELETE_VEHICLE = "DELETE FROM vehicles WHERE id=?";

    private static final String DELETE_VEHICLES = "DELETE FROM vehicles";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<Vehicle> vehicleRowMapper;

    @Override
    public List<Vehicle> find() {
        try {
            return jdbcTemplate.query(SELECT_VEHICLES, vehicleRowMapper);
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return new ArrayList<>();
    }

    @Override
    public int update(Vehicle vehicle) {
        try {
            return jdbcTemplate.update(UPDATE_VEHICLE,
                    vehicle.getModelName(),
                    vehicle.getVehicleState(),
                    vehicle.isUnderMaintenance(),
                    vehicle.getProducer(),
                    vehicle.getCargoCapacity(),
                    vehicle.getId());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }
    @Override
    public int save(Vehicle vehicle) {
        try {
            return jdbcTemplate.update(INSERT_VEHICLE,
                    vehicle.getModelName(),
                    vehicle.getVehicleState(),
                    vehicle.getProducer(),
                    vehicle.getCargoCapacity());
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

    @Override
    public int[] saveList(List<Vehicle> vehicles) {
        try {
            return jdbcTemplate.batchUpdate(INSERT_VEHICLE, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1, vehicles.get(i).getModelName());
                    ps.setInt(2, vehicles.get(i).getVehicleState());
                    ps.setString(3, vehicles.get(i).getProducer());
                    ps.setDouble(4, vehicles.get(i).getCargoCapacity());
                }

                @Override
                public int getBatchSize() {
                    return vehicles.size();
                }
            });
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return new int[0];
    }

    @Override
    public int delete(Vehicle vehicle) {
        try {
            return jdbcTemplate.update(DELETE_VEHICLE, vehicle.getId());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

    @Override
    public int deleteList() {
        try {
            return jdbcTemplate.update(DELETE_VEHICLES);
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }
}

