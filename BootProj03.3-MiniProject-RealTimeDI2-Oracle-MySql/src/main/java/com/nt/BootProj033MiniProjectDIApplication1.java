//BootProj033MiniProjectDIApplication1.java(13.02.2025)
package com.nt;

import java.util.List;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj033MiniProjectDIApplication1 {

	public static void main(String[] args) {
		try(//Get Access To IOC Container
		ConfigurableApplicationContext ctx=SpringApplication.run(BootProj033MiniProjectDIApplication1.class, args);
				
		//Get Scanner Class Object
		Scanner sc=new Scanner(System.in);
		){
			
		//Get Controller Class Object Reference
		PayrollOperationsController controller=ctx.getBean("payroll",PayrollOperationsController.class);
		//Read Inputs From The End User
		System.out.println("Enter Degs1::");
		String degs1=sc.next();
		
		System.out.println("Enter Degs2::");
		String degs2=sc.next();
		
		System.out.println("Enter Degs3::");
		String degs3=sc.next();
		
		//Invoke The Business Method
			List<Employee> list=controller.showAllEmployeesByDegs(degs1,degs2, degs3);
			//Process The Results
			System.out.println("Employees Belonging To "+degs1+" "+degs2+" "+degs3+"  Are ");
			list.forEach(emp->{
				System.out.println(emp);
			     });
		}//Try
		catch(Exception e) {
			System.out.println("Internal Problem::"+e.getMessage());
			e.printStackTrace();
		}
	}//Main
}//Class
