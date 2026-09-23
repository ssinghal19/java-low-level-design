package com.shreya.parkinglot.gate;

import com.shreya.parkinglot.model.ParkingLot;
import com.shreya.parkinglot.model.Ticket;
import com.shreya.parkinglot.model.Vehicle;

import java.util.Objects;

public final class EntryGate {
    private final ParkingLot lot;

    public EntryGate(ParkingLot lot) {
        this.lot = Objects.requireNonNull(lot, "Parking lot is required");
    }

    public Ticket issueTicket(Vehicle vehicle) {
        return lot.enter(vehicle);
    }
}