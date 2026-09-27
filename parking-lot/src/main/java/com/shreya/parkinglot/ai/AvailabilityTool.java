package com.shreya.parkinglot.ai;

import com.shreya.parkinglot.enums.VehicleType;
import com.shreya.parkinglot.model.ParkingLot;

import java.util.Objects;

public final class AvailabilityTool {
    private final ParkingLot lot;

    public AvailabilityTool(ParkingLot lot) {
        this.lot = Objects.requireNonNull(lot, "Parking lot is required");
    }

    public int getAvailableSpots(VehicleType vehicleType) {
        return lot.availableSpots(vehicleType);
    }
}