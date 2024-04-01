package com.company.autobase.dao.travel_routesDAO;

import com.company.autobase.model.TravelRoute;

import java.util.List;


public interface TravelRouteDao {
    int save(TravelRoute travelRoute);

    int delete(TravelRoute travelRoute);

    int deleteList();

    int[] saveList(List<TravelRoute> travelRoutes);

    List<TravelRoute> find();

}