//WishMessageGenerator.java(30.12.2024)
package com.nt.sbeans;

import java.time.LocalTime;

public class WishMessageGenerator {
	
      private LocalTime lt;//HAS-A property
      
     public WishMessageGenerator() {
    	 System.out.println("WishMessageGenerator::0-Param Constructor");
     }

     //Setter Method For Setter Injection (Alt+Shift+s,r)
 	public void setLt(LocalTime lt) {
 		System.out.println("WishMessageGenerator.SetLt()");
 		this.lt = lt;
 	}
 	
     //Business Method
 	public String generateWishMessage(String user) {
 		System.out.println("WishMessageGenerator.generateWishMessage()");
 		
 		//get current hour of the day
 		int hour=lt.getHour();//in 24 hrs format
 		if(hour<12)
 			return "Good Morning!"+user;
 		else if(hour<16)
 			return "Good Afternoon!"+user;
 		else if(hour<20)
 			return "Good Evening!"+user;
 		else
 			return "Good Night!"+user;
 	}
}
