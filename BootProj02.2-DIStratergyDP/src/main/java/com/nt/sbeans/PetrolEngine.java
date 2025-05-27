//PetrolEngine.java(06.02.2025)
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("pEngine")
public final class PetrolEngine implements IEngine{

	public PetrolEngine() {
		System.out.println("PetrolEngine::0-Param Constructor");
	}
	
	@Override
	public void start() {
		System.out.println("PetrolEngine.start()::Engine Started");
	}
	
	@Override
	public void stop() {
		System.out.println("PetrolEngine.stop()::Engine Stopped");
	}
}
