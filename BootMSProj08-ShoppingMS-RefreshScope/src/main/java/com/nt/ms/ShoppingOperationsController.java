//ShoppingOperationsController.java(20.05.2025)
package com.nt.ms;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingMSClientComp;

@RestController
@RequestMapping("/shopping-api")
@RefreshScope
public class ShoppingOperationsController {
	@Autowired
	private IBillingMSClientComp client;
	@Value("${db.user}")
	private String dbUser;
	@Value("${db.password}")
	private String dbPassword;
	
	public ShoppingOperationsController() {
		  System.out.println("ShoppingOperationsController::0-Param Constructor");
	}

	@GetMapping("/purchase")
     public ResponseEntity<String> doShopping(){
		System.out.println("Client Component Proxy class name::"+client.getClass());
		System.out.println("Proxy Class Implemented interfaces::"+Arrays.toString(client.getClass().getInterfaces()));
		System.out.println("Proxy Class methods::"+Arrays.toString(client.getClass().getDeclaredMethods()));
    	String msg="Shirt,Trouser items are purchased db.user="+dbUser+"...."+"db.pwd="+dbPassword;
    	 //Invoke Target MS endpoint through client Component
    	 ResponseEntity<String> resp=client.invokeDoBilling();
    	 //Generate The final Result
    	 String result=msg+"....."+resp.getBody();
    	 //Return ResponseEntity Object
    	 return new ResponseEntity<String>(result,HttpStatus.OK);
     }
}
