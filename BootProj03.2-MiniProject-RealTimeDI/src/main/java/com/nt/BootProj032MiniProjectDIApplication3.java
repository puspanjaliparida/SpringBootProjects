//BootProj032MiniProjectDIApplication3.java (12.02.2025)
package com.nt;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ApplicationContext;

import com.nt.controller.PayrollOperationsController;

@SpringBootApplication
public class BootProj032MiniProjectDIApplication3 {

	public static void main(String[] args) {
        // Get IOC Container
        ApplicationContext ctx = SpringApplication.run(BootProj032MiniProjectDIApplication3.class, args);
        // Get Controller Class Object Reference
        PayrollOperationsController controller = ctx.getBean("payroll", PayrollOperationsController.class);
        try (// Read Input From End User
		Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Hospital ID To Delete::");
			int hospitalId = sc.nextInt();

			try {
			    String resultMsg = controller.processHospitalDelete(hospitalId);
			    System.out.println(resultMsg);
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}

        ((ConfigurableApplicationContext) ctx).close();
    }// Main
}// Class