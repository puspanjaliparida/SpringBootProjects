//BootProj041ValueAnnotationSpelApplication(15.02.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Hotel;

@SpringBootApplication
public class BootProj041ValueAnnotationSpelApplication {

	public static void main(String[] args) {
		//Get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj041ValueAnnotationSpelApplication.class, args);
		//Get Hotel Object Reference
		Hotel hotel=ctx.getBean("hotel",Hotel.class);
		System.out.println(hotel);
		//Close The IOC Container
		((ConfigurableApplicationContext) ctx).close();
	}//Main
}//Class
