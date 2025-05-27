//ProfilesTestRunner(21.02.2025)
package com.nt.runners;

import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@Component
public class ProfilesTestRunner1 implements CommandLineRunner{

	@Autowired
	private PayrollOperationsController controller;
	
	@Override
	public void run(String... args) throws Exception {
		  System.out.println("ProfilesTestRunner.run()");
		  
			try (//Get Scanner Class Object
			Scanner sc = new Scanner(System.in)) {
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
			}
			}
}
