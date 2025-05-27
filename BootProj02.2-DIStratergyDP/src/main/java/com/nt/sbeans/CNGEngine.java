//CNGEngine.java(06.02.2025)
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("cEngine")
public final class CNGEngine implements IEngine{

	public CNGEngine() {
		System.out.println("CNGEngine::0-Param Constructor");
	}
	
	@Override
	public void start() {
		System.out.println("CNGEngine.start()::Engine Started");
	}
	
	@Override
	public void stop() {
		System.out.println("CNGEngine.stop()::Engine Stopped");
	}
}
