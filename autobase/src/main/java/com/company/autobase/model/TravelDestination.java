package com.company.autobase.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "travel_destinations")
@AllArgsConstructor
@NoArgsConstructor
public class TravelDestination {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "travel_distance")
    double travel_distance;

    @Column(name = "destination_country")
    String destination_country;

    @Column(name = "destination_city")
    String destination_city;
}
