//StudentRegistrationTestRunner.java(11.03.2025)
package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.StudentRegistrationInfo;
import com.nt.service.IStudentRegistrationMgmtService;

@Component
public class StudentRegistrationTestRunner implements CommandLineRunner{
      @Autowired
      private IStudentRegistrationMgmtService service;
      
      @Override
      public void run(String... args) throws Exception{
    	  /*try {
    		  StudentRegistrationInfo info=new StudentRegistrationInfo("Khushi","Java","11AM");
    		  System.out.println(service.saveStudentRegistrationInfo(info));
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
    	  System.out.println("===================================");*/
    	  
    	 try {
    		  System.out.println(service.updateStudentRegistrationInfoById(1, "Khushi", "HTML","11AM"));
    		  System.out.println(service.showStudentDetailsById(1));
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
    	  System.out.println("====================================");
    	  
    	 try {
    		  System.out.println(service.updateStudentRegistrationInfoById(1, "Khushi", "Oracle","4PM"));
    		  System.out.println(service.showStudentDetailsById(1));
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
      }//Run()
}//Class
