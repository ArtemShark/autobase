package com.company.autobase.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class FinishedTravelRoute {
    private int id;
    private Date startDate;
    private Date finishDate;
    private long routeId;
}
