package com.shreya.parkinglot.ai;

import com.shreya.parkinglot.model.ParkingLot;
import com.shreya.parkinglot.model.Ticket;

import java.util.Objects;

public final class TicketLookupTool {
    private final ParkingLot lot;

    public TicketLookupTool(ParkingLot lot) {
        this.lot = Objects.requireNonNull(lot, "Parking lot is required");
    }

    public String findTicket(String ticketId) {
        Ticket ticket = lot.findActiveTicket(ticketId);

        if (ticket == null) {
            return "No active ticket found for ID: " + ticketId;
        }

        return "Ticket " + ticket.getId()
                + " is active. Vehicle type: " + ticket.getVehicle().getType()
                + ", floor: " + ticket.getFloorId()
                + ", spot: " + ticket.getSpot().getId() + ".";
    }
}