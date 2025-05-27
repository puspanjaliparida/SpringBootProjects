//BootProj05ConfigurationPropertiesApplication(Main Class)(17.02.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Company;

@SpringBootApplication
public class BootProj05ConfigurationPropertiesApplication {

	public static void main(String[] args) {
		//Get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj05ConfigurationPropertiesApplication.class, args);
		//Get Company Class Object Reference
     	Company company=ctx.getBean("comp",Company.class);
	    System.out.println(company);
	
		//Close Container
		((ConfigurableApplicationContext) ctx).close();
	}
}
