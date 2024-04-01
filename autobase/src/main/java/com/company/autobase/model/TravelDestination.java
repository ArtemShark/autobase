package com.company.autobase.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TravelDestination {
    private int id;
    double travelDistance;
    String destinationCountry;
    String destinationCity;
}