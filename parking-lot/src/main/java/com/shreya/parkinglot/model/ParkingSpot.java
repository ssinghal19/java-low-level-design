package com.shreya.parkinglot.model;

import com.shreya.parkinglot.enums.SpotType;
import java.util.Objects;

public abstract class ParkingSpot {
    private final String id;
    private final SpotType type;
    private Vehicle parkedVehicle;

    protected ParkingSpot(String id, SpotType type) {
        this.id = Objects.requireNonNull(id, "Spot ID is required");
        this.type = Objects.requireNonNull(type, "Spot type is required");
    }

    public String getId() {
        return id;
    }

    public SpotType getType() {
        return type;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void park(Vehicle vehicle) {
        Objects.requireNonNull(vehicle, "Vehicle is required");
        if (!isAvailable() || !accepts(vehicle)) {
            throw new IllegalStateException("Spot is occupied or incompatible: " + id);
        }
        parkedVehicle = vehicle;
    }

    public void release() {
        if (isAvailable()) {
            throw new IllegalStateException("Spot is already empty: " + id);
        }
        parkedVehicle = null;
    }

    public abstract boolean accepts(Vehicle vehicle);
}