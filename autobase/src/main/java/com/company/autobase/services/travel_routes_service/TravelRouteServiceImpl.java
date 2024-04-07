package com.company.autobase.services.travel_routes_service;


import com.company.autobase.dao.travel_routesDAO.TravelRouteRepository;
import com.company.autobase.model.TravelRoute;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelRouteServiceImpl implements TravelRouteService {
    private final TravelRouteRepository travelRouteRepository;

    @Override
    public TravelRoute save(TravelRoute object) {
        return travelRouteRepository.save(object);
    }

    @Override
    public TravelRoute update(TravelRoute object) {
        return travelRouteRepository.save(object);
    }

    @Override
    public void delete(TravelRoute object) {
        travelRouteRepository.delete(object);
    }

    @Override
    public void deleteList() {
        travelRouteRepository.deleteAll();
    }

    @Override
    public List<TravelRoute> find() {
        return travelRouteRepository.findAll();
    }

    @Override
    public List<TravelRoute> saveList(List<TravelRoute> objectsList) {
        return travelRouteRepository.saveAll(objectsList);
    }
}

