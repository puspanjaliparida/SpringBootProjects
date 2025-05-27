//CustomerOperationsController.java(23.04.2025)
package com.nt.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;
import com.nt.model.Customer;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {
    
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer cust){
		System.out.println("Customer Object Data::"+cust);
		return new ResponseEntity<String>(cust.toString(),HttpStatus.OK);
	}
	
	@PostMapping("/register-actor")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor){
		System.out.println("Actor Object Data::"+actor);
		return new ResponseEntity<String>(actor.toString(),HttpStatus.OK);
	}
	
	@PostMapping("/register-customers")
	public ResponseEntity<String> registerCustomers(@RequestBody List<Customer> list){
		System.out.println("List Of Customers ::"+list);
		return new ResponseEntity<String>(list.toString(),HttpStatus.OK);
	}
}
