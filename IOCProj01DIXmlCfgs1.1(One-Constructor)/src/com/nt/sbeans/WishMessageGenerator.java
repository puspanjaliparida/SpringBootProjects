//WishMessageGenerator.java(31.12.2024)
package com.nt.sbeans;

import java.time.LocalTime;

public class WishMessageGenerator {
	
      private LocalTime lt;//HAS-A Property
      
     //For Constructor  Injection (Alt+Shift+s,r)
      public WishMessageGenerator(LocalTime lt) {
  		this.lt = lt;
  		System.out.println("WishMessageGenerator::1-Param Constructor");
  	}
      
     //Business Method
 	public String generateWishMessage(String user) {
 		System.out.println("WishMessageGenerator.GenerateWishMessage()");
 		
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
