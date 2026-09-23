package com.shreya.parkinglot.pricing;

import com.shreya.parkinglot.model.Ticket;
import java.time.Instant;

public interface PricingStrategy {
    long calculateCharge(Ticket ticket, Instant exitTime);
}