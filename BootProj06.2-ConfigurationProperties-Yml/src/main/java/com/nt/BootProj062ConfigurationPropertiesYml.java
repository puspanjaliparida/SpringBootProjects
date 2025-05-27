//BootProj062ConfigurationPropertiesYml.java(18.02.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProj062ConfigurationPropertiesYml {

	public static void main(String[] args) {
		//Get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj062ConfigurationPropertiesYml.class, args);
		//Get Employee Object Reference
		Employee employee=ctx.getBean("emp",Employee.class);
		System.out.println(employee);
		//Close IOC Container
		((ConfigurableApplicationContext) ctx).close();
	}

}
