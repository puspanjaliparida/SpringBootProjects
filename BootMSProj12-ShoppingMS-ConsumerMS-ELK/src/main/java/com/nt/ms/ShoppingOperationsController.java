//ShoppingOperationsController.java(27.05.2025)
package com.nt.ms;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingMSClientComp;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/shopping-api")
@Slf4j
public class ShoppingOperationsController {
	@Autowired
	private IBillingMSClientComp client;
	
	@GetMapping("/purchase")
	@CircuitBreaker(name="ShoppingMS",fallbackMethod = "doBillingFallback")
     public ResponseEntity<String> doShopping(){
		log.debug("ShoppingMS:doShopping() method start");
		System.out.println("ShoppingOperationsController.doShopping()");
    	String msg="Shirt,Trouser items are purchased.";
    	 //Invoke Target MS endpoint through client Component
    	 ResponseEntity<String> resp=client.invokeDoBilling();
    	 log.info("Provider MS(BillingMS) is invoked");
    	 //Generate The final Result
    	 String result=msg+"....."+resp.getBody();
    	 log.debug("final result is generated");
    	 log.debug("ShoppingMS:doShopping() method end");
    	 //Return ResponseEntity Object
    	 return new ResponseEntity<String>(result,HttpStatus.OK);
     }
	
	public ResponseEntity<String> doBillingFallback(Exception e){
		log.error("Problem in communicating with Provider MS::"+e.getMessage());
	    return new ResponseEntity<String> ("Problem in BillingService",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
