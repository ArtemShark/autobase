package com.company.autobase.dao.shipment_typeDAO;

import com.company.autobase.model.ShipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ShipmentTypeRepository extends JpaRepository<ShipmentType, Long> {
    ShipmentType findShipmentTypeById(long id);
}
