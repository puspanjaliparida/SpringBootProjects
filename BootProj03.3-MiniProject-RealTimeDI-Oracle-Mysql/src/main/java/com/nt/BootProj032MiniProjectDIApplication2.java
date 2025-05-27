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
public class BootProj032MiniProjectDIApplication2 {

    public static void main(String[] args) {
        //get IOC container
        ApplicationContext ctx = SpringApplication.run(BootProj032MiniProjectDIApplication2.class, args);
        //get controller class object reference
        PayrollOperationsController controller = ctx.getBean("payroll", PayrollOperationsController.class);
        //read input from end user
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Hospital ID to update::");
        int hospitalid = sc.nextInt();
        System.out.println("Enter new Hospital Name::");
        String hospitalName = sc.next();
        System.out.println("Enter new Location::");
        String location = sc.next();
        System.out.println("Enter new phonenumber::");
        double phonenumber = sc.nextDouble();
        System.out.println("Enter new EstablishedYear::");
        int establishedyear = sc.nextInt();

        //create Hospital class object
        Hospital hospital = new Hospital();
        hospital.setHospitalid(hospitalid); // Set HOSPITALID for updating the record
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
        ((ConfigurableApplicationContext) ctx).close();
    }//main
}//class
