//BootProj034MiniProjectDIApplication4.java(14.02.2025)
package com.nt;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.ApplicationContext;

import com.nt.controller.PayrollOperationsController;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj034MiniProjectDIApplication4 {

    public static void main(String[] args) {
        // Get IOC Container
        ApplicationContext ctx = SpringApplication.run(BootProj034MiniProjectDIApplication4.class, args);
        
        // Get Controller Class Object Reference
        PayrollOperationsController controller = ctx.getBean("payroll", PayrollOperationsController.class);
        
        try (// Read Input From End User
		Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Employee Number (EMPNO) To Delete::");
			int empno = sc.nextInt();
			
			try {
			    // Call The Controller Method For Deletion
			    String resultMsg = controller.processEmployeeDelete(empno);
			    System.out.println(resultMsg);
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
        ((ConfigurableApplicationContext) ctx).close();
    }//Main
}//Class
