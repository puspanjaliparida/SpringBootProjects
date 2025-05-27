//BootProj03.2MiniProjectDIApplication.java(12.02.2025)
package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Hospital;

@SpringBootApplication
public class BootProj032MiniProjectDIApplication {

	public static void main(String[] args) {
		try(//get access to IOC container
		ConfigurableApplicationContext ctx=SpringApplication.run(BootProj032MiniProjectDIApplication.class, args);
				
		//get Scanner class object
		Scanner sc=new Scanner(System.in);
		){
			
		//get Controller class object reference
		PayrollOperationsController controller=ctx.getBean("payroll",PayrollOperationsController.class);
		//read inputs from the end user
		System.out.println("Enter location1::");
		String location1=sc.next();
		
		System.out.println("Enter location2::");
		String location2=sc.next();
		
		System.out.println("Enter location3::");
		String location3=sc.next();
		
		System.out.println("Enter location4::");
		String location4=sc.next();
		
		System.out.println("Enter location5::");
		String location5=sc.next();
		
		//invoke the business method
			List<Hospital> list=controller.showAllHospitalByDegs(location1,location2, location3,location4,location5);
			//process the results
			System.out.println("Hospital belonging to "+location1+" "+location2+" "+location3+" "+location4+" "+location5+"  are ");
			  if(list.isEmpty()) {
	                System.out.println("No hospitals found for the given locations.");
	            } else {
	                list.forEach(hospital -> System.out.println(hospital));
	            }
	        }
		catch(Exception e) {
			System.out.println("Internal Problem::"+e.getMessage());
			e.printStackTrace();
		}
	}//main
}//class
