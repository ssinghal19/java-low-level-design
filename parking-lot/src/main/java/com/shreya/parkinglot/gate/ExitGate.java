package com.shreya.parkinglot.gate;

import com.shreya.parkinglot.model.ParkingLot;
import com.shreya.parkinglot.model.Payment;

import java.util.Objects;

public final class ExitGate {
    private final ParkingLot lot;

    public ExitGate(ParkingLot lot) {
        this.lot = Objects.requireNonNull(lot, "Parking lot is required");
    }

    public Payment closeTicket(String ticketId) {
        return lot.exit(ticketId);
    }
}