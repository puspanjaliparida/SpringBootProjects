//HomeOperationsController.java(16.04.2025)
package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeOperationsController {
	
	@GetMapping("/")
    public String showHomePage() {
    	return "redirect:emp-api/home";
    }
}
