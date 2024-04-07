package com.company.autobase.dao.travel_routesDAO;

import com.company.autobase.model.TravelRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TravelRouteRepository extends JpaRepository<TravelRoute, Long> {
}
