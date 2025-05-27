//WishMessageGenerator.java(Target Spring Bean Class)(04.02.2025)
package com.nt.sbeans;

import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	@Autowired  //Field Injection
      private LocalTime lt;//HAS-A Property
      
     public WishMessageGenerator() {
		System.out.println("WishMessageGenerator::0-param constructor");
	}

	//Business Method
 	public String generateWishMessage(String user) {
 
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
