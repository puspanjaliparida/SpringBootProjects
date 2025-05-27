//Vehicle.java(Target Class)(06.02.2025)
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public final class Vehicle {
	@Autowired
	@Qualifier("pEngine")
	private IEngine engine;
	
	public Vehicle() {
		System.out.println("Vehicle::0-Param Constructor");
	}
	
	//Business Method
	public void journey(String sourcePlace,String destPlace) {
		System.out.println("Vehicle.journey");
		engine.start();
		System.out.println("Journey Started At::"+sourcePlace);
		System.out.println("Journey Is Going On.......");
		engine.stop();
		System.out.println("Journey Stopped At::"+destPlace);
	}
}
