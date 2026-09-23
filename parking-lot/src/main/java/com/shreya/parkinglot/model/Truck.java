package com.shreya.parkinglot.model;

import com.shreya.parkinglot.enums.VehicleType;

public final class Truck extends Vehicle {

    public Truck(String registrationNumber) {
        super(registrationNumber, VehicleType.TRUCK);
    }
}