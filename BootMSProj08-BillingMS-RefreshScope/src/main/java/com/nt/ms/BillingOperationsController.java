//BillingOperationsController.java(20.05.2025)
package com.nt.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
@RefreshScope
public class BillingOperationsController {
   
	@Value("${eureka.instance.instance-id}")
	private String instanceid;
	@Value("${server.port}")
	private Integer port;
	
	@Value("${db.user}")
	private String dbUser;
	
	@Value("${db.password}")
	private String dbPassword;
	
	public BillingOperationsController() {
	      System.out.println("BillingOperationsController::0-Param Constructor");	
	}

	@GetMapping("/bill")
	public ResponseEntity<String> doBilling(){
		//Generate billAmt
		long billAmt=new Random().nextLong(1000000);
		//Return ResponseEntity Object
		return new ResponseEntity<String>("Bill Amount :: "+billAmt+"...."+instanceid+"...."+port+"db user="+dbUser+"db pwd="+dbPassword,HttpStatus.OK);
	}
}
