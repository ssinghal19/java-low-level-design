package com.shreya.parkinglot.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ParkingFloor {
    private final String id;
    private final List<ParkingSpot> spots;

    public ParkingFloor(String id, List<ParkingSpot> spots) {
        if (id == null || id.trim().isEmpty() || spots == null) {
            throw new IllegalArgumentException("Floor ID and spots are required");
        }

        Set<String> ids = new HashSet<>();
        for (ParkingSpot spot : spots) {
            if (spot == null || !ids.add(spot.getId())) {
                throw new IllegalArgumentException("Duplicate or null spot");
            }
        }

        this.id = id;
        this.spots = Collections.unmodifiableList(new ArrayList<>(spots));
    }

    public String getId() {
        return id;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }
}