package com.company.autobase.dao.travel_destinationsDAO;

import com.company.autobase.model.TravelDestination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TravelDestinationRepository extends JpaRepository<TravelDestination, Long> {
}

