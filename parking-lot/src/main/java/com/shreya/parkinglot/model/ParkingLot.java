package com.shreya.parkinglot.model;

import com.shreya.parkinglot.enums.VehicleType;
import com.shreya.parkinglot.pricing.PricingStrategy;

import java.time.Clock;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public final class ParkingLot {
    private final List<ParkingFloor> floors;
    private final PricingStrategy pricing;
    private final Clock clock;

    private final Map<String, Ticket> activeTickets = new HashMap<>();
    private final Map<String, String> parkedRegistrations = new HashMap<>();

    public ParkingLot(List<ParkingFloor> floors, PricingStrategy pricing, Clock clock) {
        Objects.requireNonNull(floors, "Floors are required");
        this.pricing = Objects.requireNonNull(pricing, "Pricing strategy is required");
        this.clock = Objects.requireNonNull(clock, "Clock is required");

        Set<String> floorIds = new HashSet<>();
        for (ParkingFloor floor : floors) {
            if (floor == null || !floorIds.add(floor.getId())) {
                throw new IllegalArgumentException("Duplicate or null floor");
            }
        }
        this.floors = Collections.unmodifiableList(new ArrayList<>(floors));
    }

    public synchronized Ticket enter(Vehicle vehicle) {
        Objects.requireNonNull(vehicle, "Vehicle is required");

        if (parkedRegistrations.containsKey(vehicle.getRegistrationNumber())) {
            throw new IllegalStateException("Vehicle is already parked");
        }

        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getSpots()) {
                if (spot.isAvailable() && spot.accepts(vehicle)) {
                    spot.park(vehicle);

                    Ticket ticket = new Ticket(
                            UUID.randomUUID().toString(),
                            vehicle,
                            spot,
                            floor.getId(),
                            clock.instant()
                    );

                    activeTickets.put(ticket.getId(), ticket);
                    parkedRegistrations.put(vehicle.getRegistrationNumber(), ticket.getId());
                    return ticket;
                }
            }
        }

        throw new IllegalStateException("No compatible spot available");
    }

    public synchronized Payment exit(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            throw new IllegalArgumentException("Unknown or closed ticket");
        }

        Instant exitTime = clock.instant();
        long amount = pricing.calculateCharge(ticket, exitTime);

        ticket.getSpot().release();
        ticket.close();
        activeTickets.remove(ticketId);
        parkedRegistrations.remove(ticket.getVehicle().getRegistrationNumber());

        return new Payment(ticketId, amount, exitTime);
    }

    public synchronized int availableSpots(VehicleType type) {
        Vehicle candidate = new Vehicle("availability-check", type);
        int count = 0;

        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getSpots()) {
                if (spot.isAvailable() && spot.accepts(candidate)) {
                    count++;
                }
            }
        }
        return count;
    }
}