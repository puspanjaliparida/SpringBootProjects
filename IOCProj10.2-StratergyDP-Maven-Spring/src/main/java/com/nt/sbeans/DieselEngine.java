//PetrolEngine.java(11.01.2025)
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngine")
public class DieselEngine implements IEngine{

	@Override
	public void startEngine() {
		System.out.println("DieselEngine::Diesel Engine Started()");
	}
	
	@Override
	public void stopEngine() {
		System.out.println("DieselEngine::Diesel Engine Stopped()");
	}
}
