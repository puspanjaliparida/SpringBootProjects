//DateTimeTestRunner.java(12.03.2025)
package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee_Date_Time;
import com.nt.service.IEmployeeMgmtService;

@Component
public class DateTimeTestRunner implements CommandLineRunner {
      @Autowired
      private IEmployeeMgmtService service;
      
      @Override
      public void run(String... args) throws Exception {
    	  try {
    		  //Save The Object
    		  Employee_Date_Time emp=new Employee_Date_Time("Pankaj","Salesman",
    				                                                                                                                             LocalDateTime.of(1990, 10,20,11,35),
    				                                                                                                                             LocalTime.of(17,45),
    				                                                                                                                             LocalDate.of(2020,10, 30));
    		  String result=service.saveEmployee(emp);
    		  System.out.println(result);
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
    	  System.out.println("============================");
    	  
    	  try {
    		  service.getAllEmployees().forEach(System.out::println);
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
    	  
    	  try {
    		  service.showEmployeeAgesByDegs("Salesman").forEach(System.out::println);
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
    	  
    	  try {
    		  System.out.println("Employee Age Is::"+service.getAgeByEno(1));
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
      }//Run(-)
}//Class
