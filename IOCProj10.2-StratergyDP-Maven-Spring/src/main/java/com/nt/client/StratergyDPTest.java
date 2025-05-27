//StratergyDPTest.java(Client Application)(11.01.2025)
package com.nt.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.Vehicle;

public class StratergyDPTest {
       
	public static void main(String[] args) {
		//Create IOC Container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//Get Target Spring Bean Class Object
		Vehicle vehicle=ctx.getBean("vehicle",Vehicle.class);
		// Invoke The Business Method And Print The Result
        String result = vehicle.journey("hyd", "goa");
        System.out.println(result);
		//Close The Container
		ctx.close();
	}
}
