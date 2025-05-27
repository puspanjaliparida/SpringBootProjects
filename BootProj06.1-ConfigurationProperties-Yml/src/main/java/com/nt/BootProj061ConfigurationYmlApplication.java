//BootProj06ConfigurationYmlApplication.java(18.02.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Customer;

@SpringBootApplication
public class BootProj061ConfigurationYmlApplication {

	public static void main(String[] args) {
		//Get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj061ConfigurationYmlApplication.class, args);
		//Get Customer Object Reference
		Customer customer=ctx.getBean("cust",Customer.class);
		System.out.println(customer);
		//Close IOC Container
		((ConfigurableApplicationContext) ctx).close();
	}

}
