//BootProj033MiniProjectDIApplication3.java(14.02.2025)
package com.nt;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.ApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj034MiniProjectDIApplication3 {

	public static void main(String[] args) {
	    //get IOC container
	    ApplicationContext ctx = SpringApplication.run(BootProj034MiniProjectDIApplication3.class, args);
	    //Get Controller Class Object Reference
	    PayrollOperationsController controller = ctx.getBean("payroll", PayrollOperationsController.class);
	    try (//Read Input From End User
		Scanner sc = new Scanner(System.in)) {
			Employee emp = new Employee();
			System.out.println("Enter Employee Number (EMPNO) To Update::");
			int empno = sc.nextInt();
			sc.nextLine(); // Consume Leftover Newline

			System.out.println("Enter New Ename::");
			String ename = sc.nextLine();

			System.out.println("Enter New Sal::");
			String salStr = sc.nextLine();
			Double sal = null;
			try {
			    sal = Double.parseDouble(salStr);
			} catch (NumberFormatException e) {
			    System.out.println("Invalid Salary Input. Please Enter A Numeric Value.");
			    return;
			}

			System.out.println("Enter New Job::");
			String job = sc.nextLine();
			
			System.out.println("Enter New Deptno (10,20,30,40...)");
			int deptno = sc.nextInt();

			// Set Employee Details
			emp.setEmpno(empno);
			emp.setEname(ename);
			emp.setSal(sal); 
			emp.setJob(job);
			emp.setDeptno(deptno);
			
			try {
			    String resultMsg = controller.processEmployeeUpdate(emp);
			    System.out.println(resultMsg);
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
	    ((ConfigurableApplicationContext) ctx).close();
	}
}//Class
