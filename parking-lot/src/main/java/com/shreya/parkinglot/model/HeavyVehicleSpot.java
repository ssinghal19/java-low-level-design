package com.shreya.parkinglot.model;

import com.shreya.parkinglot.enums.SpotType;
import com.shreya.parkinglot.enums.VehicleType;

public final class HeavyVehicleSpot extends ParkingSpot {

    public HeavyVehicleSpot(String id) {
        super(id, SpotType.HEAVY_VEHICLE);
    }

    @Override
    public boolean accepts(Vehicle vehicle) {
        return vehicle.getType() == VehicleType.TRUCK;
    }
}