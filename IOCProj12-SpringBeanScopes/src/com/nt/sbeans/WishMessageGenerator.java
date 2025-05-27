//WishMessageGenerator.java (Target Spring Bean Class)(21.01.2025) 
package com.nt.sbeans;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

	@Component("wmg")
	//@Scope("prototype")
	@Scope("request")
	public class WishMessageGenerator {
		@Autowired
		private  LocalTime  lt;  // HAS-A Property
		@Autowired
		@Qualifier("ld")
		private  LocalDate  ld;  // HAS -A Property
		
		/*	@Autowired
			public WishMessageGenerator(LocalDate ld ,LocalTime lt){
				this.ld=ld;
				this.lt=lt;
				System.out.println("WishMessageGenerator:: 2-Param Constructor");
			}
			
			@Autowired
			public  void  assign(LocalTime  lt) {
				System.out.println("WishMessageGenerator.Assign()");
				this.lt=lt;
			}
			@Autowired
			public void   push(LocalDate  ld) {
				System.out.println("WishMessageGenerator.Push()");
				this.ld=ld;
			}
		
			
			@Autowired
			public  void setLt(LocalTime lt) {
				System.out.println("WishMessageGenerator.SetLt()");
				this.lt=lt;
			}
			
			@Autowired
			public void  setLd(LocalDate ld) {
				System.out.println("WishMessageGenerator.SetLd()");
				this.ld=ld;
			}
		*/	
		
		/*//Alt+Shift+s,o   (To  Get Parameterized Constructor)
		@Autowired(required = false)
		public WishMessageGenerator(LocalTime lt, LocalDate ld) {
		 System.out.println("WishMessageGenerator:: 2-Param Constructor");
		this.lt = lt;
		this.ld = ld;
		}
		
		//Alt+Shift+s,o   (To  Get Parameterized Constructor)
		@Autowired(required = false)
		public WishMessageGenerator(LocalTime lt) {
		System.out.println("WishMessageGenerator:: 1-Param Constructor");
		this.lt = lt;
		this.ld = ld;
		}
		*/ 	
	
	/*	@Autowired
		public void setLt(LocalTime lt) {
			System.out.println("WishMessageGenerator.SetLt()");
			this.lt = lt;
		}
	
		@Autowired
		public void setLd(LocalDate ld) {
			System.out.println("WishMessageGenerator.SetLd()");
			this.ld = ld;
		}
	*/
	//Business Method
 	public String   generateWishMessage(String user) {
 		System.out.println("WishMessageGenerator.GenerateWishMessage()::"+lt+"...."+ld);
 		// Get Current Hour Of The Day
 		int hour=lt.getHour();  // In 24 Hrs Format
 		if(hour<12 )
 			return  "Good Morning :"+user;
 		else if(hour<16)
 			return  "Good AfterNoon:"+user;
 		else if(hour<20)
 			return "Good Evening:"+user;
 		else
 			return "Good Night:"+user;
 	}

	
 	

	

}
