//SeasonFinderOperationsController.java(01.04.2025)
package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.ISeasonFinderMgmtService;

@Controller
@RequestMapping("/season-ops")
public class SeasonFinderOperationsController {
	@Autowired
     private ISeasonFinderMgmtService service;	   
	
//	@RequestMapping("/")
	@GetMapping
	public String showHomePage() {
		System.out.println("SeasonFinderOperationsController.showHomePage()");
		return "welcome";   //LVN
	}
	
	@PostMapping
	public String showHomePage1() {
		System.out.println("SeasonFinderOperationsController.showHomePage()");
		return "welcome1";   //LVN
	}
	@RequestMapping("/season")
	public String showSeason(Map<String,Object> map) {
		//Use Service
		String msg=service.findSeason();
		//Keep Results In Model Attribute
		map.put("resultMsg", msg);
		//Return LVN
		return "show_result";
	}
	
	/*@RequestMapping({"/report","/report1","/report2","/report3"})
	public String showReport1() {
		System.out.println("SeasonFinderOperationsController.showReport1()");
		return "show_report1";
	}
	
	@RequestMapping("/REPORT")
	public String showReport2() {
		System.out.println("SeasonFinderOperationsController.showReport2()");
		return "show_report2";
	}*/
	
	//@RequestMapping(value="/report1",method=RequestMethod.GET)
	@GetMapping("/report1")
	//@PostMapping("/report1")
	public String showReport1() {
		System.out.println("SeasonFinderOperationsController.showReport1()(GET)");
		return "forward:/test-ops/report1";
	}
	
	//@RequestMapping(value="/report1",method=RequestMethod.POST)
	@PostMapping("/report1")
	public String showReport2() {
		System.out.println("SeasonFinderOperationsController.showReport2()(POST)");
		return "show_report2";
	}
}
