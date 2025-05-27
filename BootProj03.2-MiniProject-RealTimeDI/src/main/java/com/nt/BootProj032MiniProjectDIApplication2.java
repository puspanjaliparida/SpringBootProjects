//BootProj032MiniProjectDIApplication2.java (12.02.2025)
package com.nt;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.ApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Hospital;

@SpringBootApplication
public class BootProj032MiniProjectDIApplication2 {

    public static void main(String[] args) {
        //Get IOC Container
        ApplicationContext ctx = SpringApplication.run(BootProj032MiniProjectDIApplication2.class, args);
        //Get Controller Class Object Reference
        PayrollOperationsController controller = ctx.getBean("payroll", PayrollOperationsController.class);
        try (//Read Input From End User
		Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Hospital ID To Update::");
			int hospitalid = sc.nextInt();
			System.out.println("Enter New Hospital Name::");
			String hospitalName = sc.next();
			System.out.println("Enter New Location::");
			String location = sc.next();
			System.out.println("Enter New Phonenumber::");
			double phonenumber = sc.nextDouble();
			System.out.println("Enter New EstablishedYear::");
			int establishedyear = sc.nextInt();

			//Create Hospital Class Object
			Hospital hospital = new Hospital();
			hospital.setHospitalid(hospitalid); 
			hospital.setHospitalname(hospitalName);
			hospital.setLocation(location);
			hospital.setPhonenumber(phonenumber);
			hospital.setEstablishedyear(establishedyear);

			try {
			    String resultMsg = controller.processHospitalUpdate(hospital);
			    System.out.println(resultMsg);
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}

        ((ConfigurableApplicationContext) ctx).close();
    }//Main
}//Class
