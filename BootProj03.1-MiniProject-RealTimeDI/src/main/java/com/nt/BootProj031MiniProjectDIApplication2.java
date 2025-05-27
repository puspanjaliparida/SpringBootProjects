//BootProj031MiniProjectDIApplication2.java(12.02.2025)
package com.nt;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj031MiniProjectDIApplication2 {

	public static void main(String[] args) {
		//Get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj031MiniProjectDIApplication2.class, args);
		//Get Controller Class Object Reference
		PayrollOperationsController controller=ctx.getBean("payroll",PayrollOperationsController.class);
		try (//Read Input From End User
		Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Name::");
			String name=sc.next();
			System.out.println("Enter Desg::");
			String desg=sc.next();
			System.out.println("Enter Salary::");
			double salary=sc.nextDouble();
			System.out.println("Enter Deptno(10,20,30,40...)");
			int  deptno=sc.nextInt();
			
			//Create Employee Class Object
			Employee emp=new Employee();
			emp.setEname(name);
			emp.setDegs(desg);
			emp.setSalary(salary);
			emp.setDeptno(deptno);
			
			try {
				String resultMsg=controller.processEmployeeInsert(emp);
				System.out.println(resultMsg);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
