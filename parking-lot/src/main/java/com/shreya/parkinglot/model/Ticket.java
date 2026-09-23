package com.shreya.parkinglot.model;

import java.time.Instant;
import java.util.Objects;

public final class Ticket {
    private final String id;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final String floorId;
    private final Instant entryTime;
    private boolean closed;

    Ticket(String id, Vehicle vehicle, ParkingSpot spot, String floorId, Instant entryTime) {
        this.id = id;
        this.vehicle = vehicle;
        this.spot = spot;
        this.floorId = floorId;
        this.entryTime = Objects.requireNonNull(entryTime, "Entry time is required");
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public String getFloorId() {
        return floorId;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public boolean isClosed() {
        return closed;
    }

    void close() {
        closed = true;
    }
}