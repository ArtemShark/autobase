package com.company.autobase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "travel_routes")
@AllArgsConstructor
@NoArgsConstructor
public class TravelRoute {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private CargoOrders cargoOrders;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private DriverInfo driverInfo;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
}