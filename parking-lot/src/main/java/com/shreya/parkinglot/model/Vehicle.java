package com.shreya.parkinglot.model;

import com.shreya.parkinglot.enums.VehicleType;
import java.util.Objects;

public class Vehicle {
    private final String registrationNumber;
    private final VehicleType type;

    public Vehicle(String registrationNumber, VehicleType type) {
        if (registrationNumber == null || registrationNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number is required");
        }
        this.registrationNumber = registrationNumber.trim();
        this.type = Objects.requireNonNull(type, "Vehicle type is required");
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleType getType() {
        return type;
    }
}