//TestOperationsController.java(01.04.2025)
package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test-ops")
public class TestOperationsController {
     @GetMapping("/report1")
     public String showTestReport() {
    	 System.out.println("TestOperationsController.showTestReport()");
    	 //Return LVN
    	 return "show_test_report";
     }
}
