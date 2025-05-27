//ElectricEngine.java(06.02.2025)
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("eEngine")
public final class ElectricEngine implements IEngine{

	public ElectricEngine() {
		System.out.println("ElectricEngine::0-Param Constructor");
	}
	
	@Override
	public void start() {
		System.out.println("ElectricEngine.start()::Engine Started");
	}
	
	@Override
	public void stop() {
		System.out.println("ElectricEngine.stop()::Engine Stopped");
	}
}
