package com.company.autobase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Builder
@Table(name = "drivers_info")
@AllArgsConstructor
@NoArgsConstructor
public class DriverInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "payment")
    private BigDecimal payment;

    @Column(name = "driver_experience")
    private double driver_experience;

    @Override
    public String toString() {
        return "  Id: " + id + "\n" +
                "  " + firstName + " " + lastName + "\n" +
                "  Payment: " + payment + "\n" +
                "  Driver Experience: " + driver_experience + "\n" +
                "-".repeat(10);
    }
}

