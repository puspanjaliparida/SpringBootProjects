//CustomerOperationsController.java(22.04.2025)
package com.nt.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;
import com.nt.model.Customer;

@RestController
@RequestMapping("/xml-api")
public class XMLDataRenderingOperationsController {
    
	@GetMapping("/customer")
	public ResponseEntity<Customer> showCustomerData(){
		Customer cust=new Customer(1001,"raja","hyd",400.00);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@GetMapping("/actor")
	public ResponseEntity<Actor> showActorData(){
		Actor actor=new Actor(1001,"Shahrukh","mumbai",899990.0,new String[] {"red","green"},
				                                       List.of("salman","ranbir"),Set.of(8899999L,62728299L),Map.of("aadhar",675362,"voterId",67228829),
				                                       new Customer(122,"raja","hyd",456773.09));
		return new ResponseEntity<Actor>(actor,HttpStatus.OK);
	}
	
	@GetMapping("/allcustomers")
	public ResponseEntity<List<Customer>> showCustomersData(){
		Customer cust1=new Customer(1001,"raja","hyd",7899.0);
		Customer cust2=new Customer(1002,"rajesh","vizag",4784.0);
		Customer cust3=new Customer(1003,"mahesh","delhi",2288.0);
		List<Customer> list=List.of(cust1,cust2,cust3);
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
	}
}
