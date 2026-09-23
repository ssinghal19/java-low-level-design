package com.shreya.parkinglot.factory;

import com.shreya.parkinglot.enums.VehicleType;
import com.shreya.parkinglot.model.Bike;
import com.shreya.parkinglot.model.Car;
import com.shreya.parkinglot.model.Truck;
import com.shreya.parkinglot.model.Vehicle;

public final class VehicleFactory {
    private VehicleFactory() {
    }

    public static Vehicle create(VehicleType type, String registrationNumber) {
        if (type == null) {
            throw new IllegalArgumentException("Vehicle type is required");
        }

        switch (type) {
            case BIKE:
                return new Bike(registrationNumber);
            case CAR:
                return new Car(registrationNumber);
            case TRUCK:
                return new Truck(registrationNumber);
            default:
                throw new IllegalArgumentException("Unsupported vehicle type: " + type);
        }
    }
}