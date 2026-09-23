package com.shreya.parkinglot.model;

import com.shreya.parkinglot.enums.VehicleType;

public final class Bike extends Vehicle {

    public Bike(String registrationNumber) {
        super(registrationNumber, VehicleType.BIKE);
    }
}