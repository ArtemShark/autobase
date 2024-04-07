package com.company.autobase.dao.drivers_infoDAO;

import com.company.autobase.model.DriverInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DriverInfoRepository extends JpaRepository<DriverInfo, Long> {
}
