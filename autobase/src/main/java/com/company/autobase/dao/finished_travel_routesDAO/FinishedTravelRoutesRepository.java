package com.company.autobase.dao.finished_travel_routesDAO;

import com.company.autobase.model.FinishedTravelRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FinishedTravelRoutesRepository extends JpaRepository<FinishedTravelRoute, Long> {
}
