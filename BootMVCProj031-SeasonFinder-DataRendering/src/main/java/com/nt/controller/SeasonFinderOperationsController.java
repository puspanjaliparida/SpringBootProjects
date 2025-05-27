//SeasonFinderOperationsController.java(29.03.2025)
package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ISeasonFinderMgmtService;

@Controller
public class SeasonFinderOperationsController {
	@Autowired
     private ISeasonFinderMgmtService service;	   
	
	@RequestMapping("/")
	public String showHomePage() {
		return "welcome";   //LVN
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
}
