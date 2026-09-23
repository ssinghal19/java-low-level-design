package com.shreya.parkinglot;

import com.shreya.parkinglot.enums.VehicleType;
import com.shreya.parkinglot.factory.VehicleFactory;
import com.shreya.parkinglot.gate.EntryGate;
import com.shreya.parkinglot.gate.ExitGate;
import com.shreya.parkinglot.model.FourWheelerSpot;
import com.shreya.parkinglot.model.HeavyVehicleSpot;
import com.shreya.parkinglot.model.ParkingFloor;
import com.shreya.parkinglot.model.ParkingLot;
import com.shreya.parkinglot.model.Payment;
import com.shreya.parkinglot.model.Ticket;
import com.shreya.parkinglot.model.TwoWheelerSpot;
import com.shreya.parkinglot.pricing.HourlyPricingStrategy;

import java.time.Clock;
import java.util.Arrays;

public final class Demo {
    public static void main(String[] args) {
        ParkingFloor floor = new ParkingFloor("F1", Arrays.asList(
                new TwoWheelerSpot("B1"),
                new FourWheelerSpot("C1"),
                new HeavyVehicleSpot("T1")
        ));

        ParkingLot lot = new ParkingLot(
                Arrays.asList(floor),
                new HourlyPricingStrategy(10, 20, 40),
                Clock.systemUTC()
        );

        Ticket ticket = new EntryGate(lot).issueTicket(
                VehicleFactory.create(VehicleType.CAR, "KA01AB1234")
        );
        System.out.println("Parked at " + ticket.getFloorId() + "/" + ticket.getSpot().getId());

        Payment payment = new ExitGate(lot).closeTicket(ticket.getId());
        System.out.println("Charge: " + payment.getAmount());
    }
}