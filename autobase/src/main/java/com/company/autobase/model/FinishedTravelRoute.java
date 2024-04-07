package com.company.autobase.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.sql.Date;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "finished_travel_routes")
@AllArgsConstructor
@NoArgsConstructor
public class FinishedTravelRoute {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "finish_date")
    private Date finish_date;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private TravelRoute travelRoute;
}
