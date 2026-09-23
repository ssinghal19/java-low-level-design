package com.shreya.parkinglot.model;

import com.shreya.parkinglot.enums.SpotType;
import com.shreya.parkinglot.enums.VehicleType;

public final class FourWheelerSpot extends ParkingSpot {

    public FourWheelerSpot(String id) {
        super(id, SpotType.FOUR_WHEELER);
    }

    @Override
    public boolean accepts(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.CAR;
    }
}