//BootProj031MiniProjectDIApplication.java(08/10/11.02.2025)
package com.nt;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj031MiniProjectDIApplication {

	public static void main(String[] args) {
		//Get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj031MiniProjectDIApplication.class, args);
		//Get Controller Class Object Reference
		PayrollOperationsController controller=
				ctx.getBean("payroll",PayrollOperationsController.class);
		//Invoke The Business Method
		try {
			List<Employee> list=controller.showAllEmployeesByDegs("CLERK","MANAGER", "SALESMAN");
			//Process The Results
			list.forEach(emp->{
				System.out.println(emp);
			     });
		}//Try
		catch(Exception e) {
			e.printStackTrace();
		}//Close The Container
		((ConfigurableApplicationContext)ctx).close();
	}//Main
}//Class
