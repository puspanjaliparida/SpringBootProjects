//BootProj031MiniProjectDIApplication.java (12.02.2025)
package com.nt;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ApplicationContext;
import com.nt.controller.PayrollOperationsController;
import com.nt.model.Hospital;

@SpringBootApplication
public class BootProj032MiniProjectDIApplication3 {

	public static void main(String[] args) {
        // Get IOC container
        ApplicationContext ctx = SpringApplication.run(BootProj032MiniProjectDIApplication3.class, args);
        // Get controller class object reference
        PayrollOperationsController controller = ctx.getBean("payroll", PayrollOperationsController.class);
        // Read input from end user
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Hospital ID to delete::");
        int hospitalId = sc.nextInt();

        try {
            String resultMsg = controller.processHospitalDelete(hospitalId);
            System.out.println(resultMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ((ConfigurableApplicationContext) ctx).close();
    }// main
}// class