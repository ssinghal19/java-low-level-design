package com.shreya.parkinglot.model;

import com.shreya.parkinglot.enums.VehicleType;

public final class Car extends Vehicle {

    public Car(String registrationNumber) {
        super(registrationNumber, VehicleType.CAR);
    }
}