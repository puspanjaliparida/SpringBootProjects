//BootProj022DiStratergyDpApplication(main class)(06.02.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj022DIStratergyDpApplication {

	public static void main(String[] args) {
		//Get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj022DIStratergyDpApplication.class, args);
		//Get Access To Target Spring Bean Class Object
		Vehicle vehicle=ctx.getBean("vehicle",Vehicle.class);
		//Invoke The Business Method
		vehicle.journey("Hyd","Delhi");
		
	//Close The Container
		((ConfigurableApplicationContext) ctx).close();
	}
}
