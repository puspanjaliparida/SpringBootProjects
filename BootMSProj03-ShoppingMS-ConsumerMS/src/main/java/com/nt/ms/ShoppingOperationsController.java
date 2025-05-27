//ShoppingOperationsController.java(15.05.2025)
package com.nt.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillingMSClientComp;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingOperationsController {
	@Autowired
	private BillingMSClientComp client;
	
	@GetMapping("/purchase")
     public ResponseEntity<String> doShopping(){
    	 String msg="Shirt,Trouser items are purchased.";
    	 //Invoke Target MS endpoint through client Component
    	 ResponseEntity<String> resp=client.invokeDoBilling();
    	 //Generate The final Result
    	 String result=msg+"....."+resp.getBody();
    	 //Return ResponseEntity Object
    	 return new ResponseEntity<String>(result,HttpStatus.OK);
     }
}
