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
		try(//Get Access to IOC Container
		ConfigurableApplicationContext ctx=SpringApplication.run(BootProj032MiniProjectDIApplication.class, args);
				
		//Get Scanner Class Object
		Scanner sc=new Scanner(System.in);
		){
			
		//Get Controller Class Object Reference
		PayrollOperationsController controller=ctx.getBean("payroll",PayrollOperationsController.class);
		//Read Inputs From The End User
		System.out.println("Enter Location1::");
		String location1=sc.next();
		
		System.out.println("Enter Location2::");
		String location2=sc.next();
		
		System.out.println("Enter Location3::");
		String location3=sc.next();
		
		System.out.println("Enter Location4::");
		String location4=sc.next();
		
		System.out.println("Enter Location5::");
		String location5=sc.next();
		
		//Invoke The Business Method
			List<Hospital> list=controller.showAllHospitalByDegs(location1,location2, location3,location4,location5);
			//Process The Results
			System.out.println("Hospital Belonging To "+location1+" "+location2+" "+location3+" "+location4+" "+location5+"  Are ");
			  if(list.isEmpty()) {
	                System.out.println("No Hospitals Found For The Given Locations.");
	            } else {
	                list.forEach(hospital -> System.out.println(hospital));
	            }
	        }
		catch(Exception e) {
			System.out.println("Internal Problem::"+e.getMessage());
			e.printStackTrace();
		}
	}//Main
}//Class
