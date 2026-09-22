# Parking Lot Low Level Design

## Problem Statement

Design a parking lot system that can manage vehicle entry, parking spot allocation, ticket generation, payment calculation, and vehicle exit.

## Functional Requirements

- The system should support multiple vehicle types.
- The system should support multiple parking spot types.
- The system should assign an available parking spot to a vehicle.
- The system should generate a parking ticket at entry.
- The system should calculate parking charges at exit.
- The system should free the parking spot after vehicle exit.

## Non-Functional Requirements

- The system should be extensible for new vehicle types.
- The system should be extensible for new pricing strategies.
- The design should follow SOLID principles.
- The system should be easy to test and maintain.

## Main Entities

- Vehicle
- Car
- Bike
- Truck
- ParkingSpot
- TwoWheelerSpot
- FourWheelerSpot
- HeavyVehicleSpot
- ParkingFloor
- ParkingLot
- Ticket
- EntryGate
- ExitGate
- Payment
- PricingStrategy

## Design Patterns Planned

- Factory Pattern
- Strategy Pattern
- Singleton Pattern

## Status

In Progress