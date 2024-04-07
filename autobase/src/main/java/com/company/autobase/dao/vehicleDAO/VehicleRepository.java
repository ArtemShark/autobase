package com.company.autobase.dao.vehicleDAO;

import com.company.autobase.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
