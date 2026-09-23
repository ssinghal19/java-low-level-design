package com.shreya.parkinglot.pricing;

import com.shreya.parkinglot.enums.VehicleType;
import com.shreya.parkinglot.model.Ticket;

import java.time.Duration;
import java.time.Instant;
import java.util.EnumMap;
import java.util.Map;

public final class HourlyPricingStrategy implements PricingStrategy {
    private final Map<VehicleType, Long> rates = new EnumMap<>(VehicleType.class);

    public HourlyPricingStrategy(long bikeRate, long carRate, long truckRate) {
        if (bikeRate < 0 || carRate < 0 || truckRate < 0) {
            throw new IllegalArgumentException("Rates cannot be negative");
        }

        rates.put(VehicleType.BIKE, bikeRate);
        rates.put(VehicleType.CAR, carRate);
        rates.put(VehicleType.TRUCK, truckRate);
    }

    @Override
    public long calculateCharge(Ticket ticket, Instant exitTime) {
        if (exitTime.isBefore(ticket.getEntryTime())) {
            throw new IllegalArgumentException("Exit precedes entry");
        }

        long seconds = Duration.between(ticket.getEntryTime(), exitTime).getSeconds();

        // Charge for each started hour, with a minimum of one hour.
        long hours = Math.max(1, seconds / 3600 + (seconds % 3600 == 0 ? 0 : 1));

        return Math.multiplyExact(hours, rates.get(ticket.getVehicle().getType()));
    }
}