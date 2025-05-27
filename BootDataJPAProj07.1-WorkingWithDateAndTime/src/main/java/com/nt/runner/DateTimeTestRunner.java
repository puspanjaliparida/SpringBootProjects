//DateTimeTestRunner.java(12.03.2025)
package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.JobSeeker;
import com.nt.service.IJobSeekerMgmtService;

@Component
public class DateTimeTestRunner implements CommandLineRunner {
     @Autowired
     private IJobSeekerMgmtService jsService;
     
     @Override
     public void run(String... args) throws Exception{
    	/* try {
    		 //Prepare JobSeeker Object
    		 JobSeeker js=new JobSeeker("Alia","Mumbai",
    				                                                   LocalDateTime.of(1995,10,10,17,39),
    				                                                   LocalTime.of(17, 40),
    				                                                   LocalDate.of(2024, 10,23));
    		 String msg=jsService.registerJobSeeker(js);
    		 System.out.println(msg);
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }*/
    	 
    	 /*try {
    		 jsService.showAllJobSeeker().forEach(System.out::println);
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }*/
    	 
    	 try {
    		 double age=jsService.showJsAgeById(1);
    		 System.out.println("Job Seeker Age::"+age);
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
     }
}
