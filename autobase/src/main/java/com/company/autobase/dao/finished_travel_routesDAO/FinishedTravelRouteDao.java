package com.company.autobase.dao.finished_travel_routesDAO;

import com.company.autobase.model.FinishedTravelRoute;

import java.util.List;

public interface FinishedTravelRouteDao {
    List<FinishedTravelRoute> find();
    int update(FinishedTravelRoute finishedTravelRoute);
    int save(FinishedTravelRoute finishedTravelRoute);
    int delete(FinishedTravelRoute finishedTravelRoute);

    int deleteList();
    int[] saveList(List<FinishedTravelRoute> finishedTravelRoutes);
}
