//BootProj042ValueAnnotationSpelApplication.java(15.02.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.PatientInfo;

@SpringBootApplication
public class BootProj042ValueAnnotationSpelApplication {

	public static void main(String[] args) {
		//Get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj042ValueAnnotationSpelApplication.class, args);
		//Get PatientInfo Spring Bean Class Object
		PatientInfo info=ctx.getBean("pInfo",PatientInfo.class);
		System.out.println(info);
		
		//Close The Container
		((ConfigurableApplicationContext) ctx).close();
	}
}
