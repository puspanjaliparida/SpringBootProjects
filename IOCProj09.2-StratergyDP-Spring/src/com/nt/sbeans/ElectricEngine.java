//PetrolEngine.java(11.01.2025)
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("eEngine")
public class ElectricEngine implements IEngine{

	@Override
	public void startEngine() {
		System.out.println("ElectricEngine::Electric Engine Started()");
	}
	
	@Override
	public void stopEngine() {
		System.out.println("ElectricEngine::Electric Engine Stopped()");
	}
}
