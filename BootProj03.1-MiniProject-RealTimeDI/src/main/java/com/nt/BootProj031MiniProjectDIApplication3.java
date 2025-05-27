//BootProj031MiniProjectDIApplication3.java(12.02.2025)
package com.nt;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj031MiniProjectDIApplication3 {

    public static void main(String[] args) {
        //Get IOC Container
        ApplicationContext ctx = SpringApplication.run(BootProj031MiniProjectDIApplication3.class, args);
        //Get Controller Class Object Reference
        PayrollOperationsController controller = ctx.getBean("payroll", PayrollOperationsController.class);
        try (//Read Input From End User
		Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Employee Number (EMPNO) To Update::");
			int eno = sc.nextInt();
			System.out.println("Enter New Name::");
			String name = sc.next();
			System.out.println("Enter New Desg::");
			String desg = sc.next();
			System.out.println("Enter New Salary::");
			double salary = sc.nextDouble();
			System.out.println("Enter New Deptno (10,20,30,40...)");
			int deptno = sc.nextInt();

			//Create Employee Class Object
			Employee emp = new Employee();
			emp.setEno(eno); // Set EMPNO For Updating The Record
			emp.setEname(name);
			emp.setDegs(desg);
			emp.setSalary(salary);
			emp.setDeptno(deptno);

			try {
			    String resultMsg = controller.processEmployeeUpdate(emp);
			    System.out.println(resultMsg);
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}

        ((ConfigurableApplicationContext) ctx).close();
    }//main
}//class
