//BootProj032MiniProjectDIApplication1.java (12.02.2025)
package com.nt;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Hospital;

@SpringBootApplication
public class BootProj032MiniProjectDIApplication1 {

    public static void main(String[] args) {
        //Get IOC Container
        ApplicationContext ctx = SpringApplication.run(BootProj032MiniProjectDIApplication1.class, args);
        //Get Controller Class Object Reference
        PayrollOperationsController controller = ctx.getBean("payroll", PayrollOperationsController.class);
        try (//Read Input From End User
		Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Hospital Name::");
			String hospitalName = sc.next();
			System.out.println("Enter Location::");
			String location = sc.next();
			System.out.println("Enter Phonenumber::");
			double phonenumber = sc.nextDouble();
			System.out.println("Enter Establishedyear::");
			int establishedyear = sc.nextInt();

			//Create Hospital Class Object
			Hospital hospital = new Hospital();
			hospital.setHospitalname(hospitalName);
			hospital.setLocation(location);
			hospital.setPhonenumber(phonenumber);
			hospital.setEstablishedyear(establishedyear);

			try {
			    String resultMsg = controller.processHospitalRegistration(hospital);
			    System.out.println(resultMsg);
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}

        ((ConfigurableApplicationContext) ctx).close();
    }//Main
}//Class
