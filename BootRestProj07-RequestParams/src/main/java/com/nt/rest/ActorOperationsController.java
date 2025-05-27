//ActorOperationsController.java(24.04.2025)
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationsController {
    
	/*@GetMapping("/actor")
	public ResponseEntity<String> showActorData(@RequestParam("aid") int id,
			                                                                                       @RequestParam("aname") String name){
		System.out.println("Request Param Values are:: "+id+"......."+name);
		return new ResponseEntity<String>("Request Parameters are ::" +id+"........"+name,HttpStatus.OK);
	}*/
	
	/*@GetMapping("/actor")
	public ResponseEntity<String> showActorData(@RequestParam int id,
			                                                                                       @RequestParam String name){
		System.out.println("Request Param Values are:: "+id+"......."+name);
		return new ResponseEntity<String>("Request Parameters are ::" +id+"........"+name,HttpStatus.OK);
	}*/
	
	/*@GetMapping("/actor")
	public ResponseEntity<String> showActorData(@RequestParam int id,
			                                                                                       @RequestParam(required = false) String  name){
		System.out.println("Request Param Values are:: "+id+"......."+name);
		return new ResponseEntity<String>("Request Parameters are ::" +id+"........"+name,HttpStatus.OK);
	}*/
	
	@GetMapping("/actor")
	public ResponseEntity<String> showActorData(@RequestParam int id,
			                                                                                       @RequestParam(required = false,defaultValue = "Mama") String  name){
		System.out.println("Request Param Values are:: "+id+"......."+name);
		return new ResponseEntity<String>("Request Parameters are ::" +id+"........"+name,HttpStatus.OK);
	}
}
