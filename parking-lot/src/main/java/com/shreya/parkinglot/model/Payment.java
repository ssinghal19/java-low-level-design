package com.shreya.parkinglot.model;

import java.time.Instant;

public final class Payment {
    private final String ticketId;
    private final long amount;
    private final Instant paidAt;

    Payment(String ticketId, long amount, Instant paidAt) {
        this.ticketId = ticketId;
        this.amount = amount;
        this.paidAt = paidAt;
    }

    public String getTicketId() {
        return ticketId;
    }

    public long getAmount() {
        return amount;
    }

    public Instant getPaidAt() {
        return paidAt;
    }
}