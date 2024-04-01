package com.company.autobase.model;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class TravelRoute {
    private int id;
    private int orderId;
    private int driverId;
    private int vehicleId;
}