//ShowHomeController.java(01/02.04.2025)
package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Customer;

@Controller
public class ShowHomeController {
	@GetMapping("/report")
	 public String showReport(Map<String,Object> map) {
		/*//Add Model Attributes (Arrays And Collections)
		map.put("nickNames", new String[] {"king","empirer","raja","maharaja"});
		map.put("friends",List.of("kkh","smita","pankaj","deba"));
		map.put("phones",Set.of(3638292L,783932L,3383939L,378393L));
		map.put("idDetails",Map.of("aadhar",3537738,"panNo",367383,"voterid",783393));*/
		
		/*//Add Model Attributes(Model Class Object)
		Customer cust=new Customer(1001,"raja","hyd",7899.0);
		map.put("custData", cust);*/
		
		//Add Model Attributes(List Of Model Class Objects)
		Customer cust1=new Customer(1001,"rani","blr",8000.0);
		Customer cust2=new Customer(1002,"khushi","vizag",9000.0);
		Customer cust3=new Customer(1003,"omm","pune",20000.0);
		Customer cust4=new Customer(1004,"mama","delhi",10000.0);
		
		List<Customer> list=List.of(cust1,cust2,cust3,cust4);
	    map.put("custList", list);
		return "result";
	 }
}
