package com.shreya.parkinglot.model;

import com.shreya.parkinglot.enums.SpotType;
import com.shreya.parkinglot.enums.VehicleType;

public final class TwoWheelerSpot extends ParkingSpot {

    public TwoWheelerSpot(String id) {
        super(id, SpotType.TWO_WHEELER);
    }

    @Override
    public boolean accepts(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.BIKE;
    }
}