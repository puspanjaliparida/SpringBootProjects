//StudentOperationsController.java(03.04.2025)
package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationsController {
	
	  @GetMapping("/")
      public String showHomePage() {   //For Home Page
    	  //Return LVN
		  return "welcome";
      }
	  
	  @GetMapping("/register")
	  public String showStudentFormPage() { //For Launching Form Page
		  //Return LVN
		  return "stud_register_form";
	  }
	  
	  @PostMapping("/register")
	  public String registerStudent(Map<String,Object> map,
			  @ModelAttribute("stud") Student st) {
		  System.out.println("Model Class Object Data::"+st);
		  //Write Business Logic
		  String result=null;
		  if(st.getAvg()<35) 
			  result="fail";
		  else
			  result="pass";
		  //Keep The Result In Model Attributes (Shared Memory)
		  map.put("resultMsg", result);
		  //Return LVN
		  return "show_result";
	  }
}
