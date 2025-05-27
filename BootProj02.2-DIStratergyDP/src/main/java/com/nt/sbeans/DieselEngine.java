//DieselEngine.java(06.02.2025)
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dEngine")
public final class DieselEngine implements IEngine{

	public DieselEngine() {
		System.out.println("DieselEngine::0-Param Constructor");
	}
	
	@Override
	public void start() {
		System.out.println("DieselEngine.start()::Engine Started");
	}
	
	@Override
	public void stop() {
		System.out.println("DieselEngine.stop()::Engine Stopped");
	}
}
