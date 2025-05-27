//WishMessageGenerator.java(31.12.2024)
package com.nt.sbeans;

import java.time.LocalDate;
import java.time.LocalTime;

public class WishMessageGenerator {
	
      private LocalTime lt;//HAS-A Property
      private LocalDate ld;//HAS-A Property
      
      //For Constructor Injection
     public WishMessageGenerator(LocalTime lt, LocalDate ld) {
		this.lt = lt;
		this.ld = ld;
		System.out.println("WishMessageGenerator::2-Param Constructor");
	}

	//For Setter Method For Setter Injection (Alt+Shift+s,r)
      public void setLt(LocalTime lt) {
    	System.out.println("WishMessageGenerator.setLt()");
  		this.lt = lt;
  	}
      
      public void setLd(LocalDate ld) {
      	System.out.println("WishMessageGenerator.SetLd()");
    		this.ld = ld;
    	}
     //Business  Method
 	public String generateWishMessage(String user) {
 		System.out.println("WishMessageGenerator.GenerateWishMessage()::"+lt+"..."+ld);
 		
 		//Get Current Hour Of The Day
 		int hour=lt.getHour();//In 24 Hrs Format
 		if(hour<12)
 			return "Good Morning!:"+user;
 		else if(hour<16)
 			return "Good Afternoon!:"+user;
 		else if(hour<20)
 			return "Good Evening!:"+user;
 		else
 			return "Good Night!:"+user;
 	}
}
