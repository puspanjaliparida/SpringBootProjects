//BillingOperationsController.java(15.05.2025)
package com.nt.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillingOperationsController {
   
	@Value("${eureka.instance.instance-id}")
	private String instanceid;
	
	@GetMapping("/bill")
	public ResponseEntity<String> doBilling(){
		//Generate billAmt
		long billAmt=new Random().nextLong(1000000);
		//Return ResponseEntity Object
		return new ResponseEntity<String>("Bill Amount :: "+billAmt+"...."+instanceid,HttpStatus.OK);
	}
}
