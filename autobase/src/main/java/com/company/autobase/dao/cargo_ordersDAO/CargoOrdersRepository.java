package com.company.autobase.dao.cargo_ordersDAO;

import com.company.autobase.model.CargoOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CargoOrdersRepository extends JpaRepository<CargoOrders, Long> {
}
