package com.company.autobase.dao.travel_destinationsDAO;

import com.company.autobase.model.TravelDestination;

import java.util.List;

public interface TravelDestinationDao {
    List<TravelDestination> find();
    int update(TravelDestination travelDestination);

    int save(TravelDestination travelDestination);

    int delete(TravelDestination travelDestination);

    int deleteList();

    int[] saveList(List<TravelDestination> travelDestinations);
}
