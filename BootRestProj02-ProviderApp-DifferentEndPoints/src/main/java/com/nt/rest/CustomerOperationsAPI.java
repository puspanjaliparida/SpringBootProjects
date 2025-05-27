//CustomerOperationsAPI.java(21.04.2025)
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsAPI {

	@GetMapping("/show")
	public ResponseEntity<String> showCustomerData(){
		System.out.println("CustomerOperationsAPI.showCustomerData()");
		return new ResponseEntity<String>("Showing Single Customer Data",HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(){
		System.out.println("CustomerOperationsAPI.registerCustomer()");
		return new ResponseEntity<String>("Registering the Customer",HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCustomer(){
		System.out.println("CustomerOperationsAPI.updateCustomer()");
		return new ResponseEntity<String>("Updating Complete Customer Details",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer(){
		System.out.println("CustomerOperationsAPI.deleteCustomer()");
		return new ResponseEntity<String>("Deleting the Customer Info",HttpStatus.OK);
	}
	
	@PatchMapping("/emailUpdate")
	public ResponseEntity<String> updateCustomerEmail(){
		System.out.println("CustomerOperationsAPI.updateCustomerEmail()");
		return new ResponseEntity<String>("Updating the Customer Email Info",HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<String> showAllCustomers(){
		System.out.println("CustomerOperationsAPI.showAllCustomers()");
		return new ResponseEntity<String>("Showing All Customers Info",HttpStatus.OK);
	}
}
