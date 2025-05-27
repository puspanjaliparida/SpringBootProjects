//CustomerOperationsController.java(11.04.2025)
package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.Customer;

@Controller
public class CustomerOperationsController {
	 @GetMapping("/")
     public String showHome() {
    	 //Return LVN
		 return "welcome";
     }
	 
	 @GetMapping("/register")
	 public String showCustomerFormPage(@ModelAttribute("cust") Customer cust,
			                                                                         Map<String,Object> map) {
		 //Return LVN
		 return "customer_register";
	 }
}
