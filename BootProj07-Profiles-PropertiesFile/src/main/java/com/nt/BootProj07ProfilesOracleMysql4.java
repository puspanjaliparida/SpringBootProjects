//BootProj07ProfilesOracleMysql4.java(19.02.2025)
package com.nt;

import java.util.Scanner;
import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ApplicationContext;

import com.nt.controller.PayrollOperationsController;

@SpringBootApplication
public class BootProj07ProfilesOracleMysql4 {

    public static void main(String[] args) {
        // Get IOC Container
        ApplicationContext ctx = SpringApplication.run(BootProj07ProfilesOracleMysql4.class, args);
        
        // Get Controller Class Object Reference
        PayrollOperationsController controller = ctx.getBean("payroll", PayrollOperationsController.class);
         
     // Get DataSource Bean To Print Database Details
     	DataSource ds = ctx.getBean(DataSource.class);
        System.out.println("Currently Active DataSource: " + ds.getClass().getName());
     		
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
