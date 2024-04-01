package com.company.autobase.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverInfo {
    private int id;
    private String firstName;
    private String lastName;
    private BigDecimal payment;
    private double driverExperience;

    @Override
    public String toString() {
        return "  Id: " + id + "\n" +
                "  " + firstName + " " + lastName + "\n" +
                "  Payment: " + payment + "\n" +
                "  Driver Experience: " + driverExperience + "\n" +
                "=".repeat(10);
    }
}
