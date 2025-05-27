//BootProj033MiniProjectDIApplication2.java(13.02.2025)
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
public class BootProj033MiniProjectDIApplication2 {

	public static void main(String[] args) {
		//Get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj033MiniProjectDIApplication2.class, args);
		//Get Controller Class Object Reference
		PayrollOperationsController controller=ctx.getBean("payroll",PayrollOperationsController.class);
		try (//Read Input From End User
		Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Empno::");
			int empno=sc.nextInt();
			System.out.println("Enter Ename::");
			String ename=sc.next();
			System.out.println("Enter Sal::");
			double sal=sc.nextDouble();
			System.out.println("Enter Job::");
			String job=sc.next();
			System.out.println("Enter Deptno(10,20,30,40...)");
			int  deptno=sc.nextInt();
			
			//Create Employee Class Object
			Employee emp=new Employee();
			emp.setEmpno(empno);
			emp.setEname(ename);
			emp.setSal(sal);
			emp.setJob(job);
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
	}//Main
}//Class
