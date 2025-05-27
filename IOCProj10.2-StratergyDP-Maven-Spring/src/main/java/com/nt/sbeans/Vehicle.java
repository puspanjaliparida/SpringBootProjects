// Vehicle.java(11.01.2025)
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public final class Vehicle {
    // HAS-A Property
    @Autowired
    @Qualifier("dEngine") // Refers To DieselEngine Implementation Of IEngine
    private IEngine engine;

    // Default Constructor
    public Vehicle() {
        System.out.println("Vehicle::0-Param Constructor");
    }

    // Business Method
    public String journey(String startLocation, String destination) {
        System.out.println("Vehicle.Journey()");
        
        // Start The Engine
        engine.startEngine();

        // Simulate The Journey And Print The Details
        System.out.println("Journey Started From " + startLocation + " to " + destination);

        // Stop The Engine
        engine.stopEngine();

        // Return The Journey Summary
        return "Journey From " + startLocation + " to " + destination + " Completed Successfully!";
    }
}
