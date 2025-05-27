//WishMessageGenerator.java(19.04.2025)
package com.nt.rest;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish-api")  //Global Path
public class WishMessageGenerator {
     
	@GetMapping("/wish")
	public ResponseEntity<String> showMessage(){
		//Get System Date And Time
		LocalDateTime ldt=LocalDateTime.now();
		//Generate Wish Message
		String msg=null;
		int hour=ldt.getHour();
		if(hour<12)
			msg="Good Moring !";
		else if(hour<16)
			msg="Good Afternoon !";
		else if(hour<20)
			msg="Good Evening !";
		else
			msg="Good Night !";
		//Create and Return Response Entity Object Having Response Content And Status Code
		ResponseEntity<String> entity=new ResponseEntity<String>(msg,HttpStatus.OK);
		return entity;
	}
}
