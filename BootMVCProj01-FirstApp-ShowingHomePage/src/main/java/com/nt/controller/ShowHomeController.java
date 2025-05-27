//ShowHomeController.java(26.03.2025)
package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomeController {
	   /*@RequestMapping("/home")
       public String showHomePage() {
    	   //Return LVN
		   return "welcome";
       }*/
	@RequestMapping("/")
    public String showHomePage() {
 	   //Return LVN
		   return "welcome";
    }
}
