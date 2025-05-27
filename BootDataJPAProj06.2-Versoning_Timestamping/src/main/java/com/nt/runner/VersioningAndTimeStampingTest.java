//VersioningAndTimeStampingTest.java(11.03.2025)
package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.CallerTuneInfo;
import com.nt.service.ICallerTuneMgmtService;

@Component
public class VersioningAndTimeStampingTest implements CommandLineRunner{
      @Autowired
      private ICallerTuneMgmtService service;
      
      @Override
      public void run(String... args) throws Exception{
    	  try {
    		  CallerTuneInfo info=new CallerTuneInfo("Oo Antava Mama","Pushpa");
    		  System.out.println(service.saveCallerTuneInfo(info));
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
    	  System.out.println("===================================");
    	  
    	 try {
    		  System.out.println(service.updateTuneInfoById(1, "Manwa Lage", "Chennai Express"));
    		  System.out.println(service.showCallerTuneDetailsById(1));
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
    	  System.out.println("====================================");
    	  
    	  try {
    		  System.out.println(service.updateTuneInfoById(1, "Sanam Teri Kasam", "Sanam Teri Kasam"));
    		  System.out.println(service.showCallerTuneDetailsById(1));
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
      }//Run()
}//Class
