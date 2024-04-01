package com.company.autobase.dao.drivers_infoDAO;

import com.company.autobase.AppStarter;
import com.company.autobase.model.DriverInfo;
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
public class DriverInfoDaoImpl implements DriverInfoDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppStarter.class);
    private static final String SELECT_DRIVERS = "SELECT * FROM drivers_info";
    private static final String INSERT_DRIVER = "INSERT INTO drivers_info(first_name, last_name, payment, driver_experience) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_DRIVER = "UPDATE drivers_info SET first_name=?, last_name=?, payment=?, driver_experience=? WHERE id=?";
    private static final String DELETE_DRIVER = "DELETE FROM drivers_info WHERE id=?";
    private static final String DELETE_DRIVERS = "DELETE FROM drivers_info";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<DriverInfo> driverRowMapper;

    @Override
    public List<DriverInfo> find() {
        try {
            return jdbcTemplate.query(SELECT_DRIVERS, driverRowMapper);
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return new ArrayList<>();
    }
    @Override
    public int update(DriverInfo driverInfo) {
        try {
            return jdbcTemplate.update(UPDATE_DRIVER,
                    driverInfo.getFirstName(),
                    driverInfo.getLastName(),
                    driverInfo.getPayment(),
                    driverInfo.getDriverExperience(),
                    driverInfo.getId());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

    @Override
    public int save(DriverInfo driverInfo) {
        try {
            return jdbcTemplate.update(INSERT_DRIVER,
                    driverInfo.getFirstName(),
                    driverInfo.getLastName(),
                    driverInfo.getPayment(),
                    driverInfo.getDriverExperience());

        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

    @Override
    public int[] saveList(List<DriverInfo> driverInfo) {
        try {
            return jdbcTemplate.batchUpdate(INSERT_DRIVER, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1, driverInfo.get(i).getFirstName());
                    ps.setString(2, driverInfo.get(i).getLastName());
                    ps.setBigDecimal(3, driverInfo.get(i).getPayment());
                    ps.setDouble(4, driverInfo.get(i).getDriverExperience());
                }

                @Override
                public int getBatchSize() {
                    return driverInfo.size();
                }
            });
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return new int[0];
    }

    @Override
    public int delete(DriverInfo driverInfo) {
        try {
            return jdbcTemplate.update(DELETE_DRIVER, driverInfo.getId());
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }

    @Override
    public int deleteList() {
        try {
            return jdbcTemplate.update(DELETE_DRIVERS);
        }
        catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
        }

        return 1;
    }
}
