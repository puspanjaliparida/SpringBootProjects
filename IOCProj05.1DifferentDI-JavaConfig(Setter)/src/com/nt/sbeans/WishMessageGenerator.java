//WishMessageGenerator.java(Target Spring Bean Class)(05.01.2025)
package com.nt.sbeans;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	
      private LocalTime lt;//HAS-A Property
	
      private LocalDate ld;//HAS-A Property
      
      
     public WishMessageGenerator() {
		System.out.println("WishMessageGenerator::0-Param Constructor");
	}

     @Autowired
	public void setLt(LocalTime lt) {
    	 System.out.println("WishMessageGenerator.SetLt()");
		this.lt = lt;
	}

     @Autowired
	public void setLd(LocalDate ld) {
    	 System.out.println("WishMessageGenerator.SetLd()");
		this.ld = ld;
	}

	//Business Method
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
