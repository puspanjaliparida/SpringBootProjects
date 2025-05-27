//EmployeeOperationsController.java(13.04.2025)
package com.nt.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Map;

import org.hibernate.query.SortDirection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationsController {
	
	 @Autowired
     private IEmployeeMgmtService empService;
     
	 @GetMapping("/")
	 public String showHome() {
		 //Return LVN
		 return "home";
	 }
	 
	 @GetMapping("emp_report")
	 public String showEmployeeReport(@PageableDefault(page = 0,size = 3,sort="job",direction = Sort.Direction.ASC) Pageable pageable,
			                                                               Map<String,Object> map) {
		 System.out.println("EmployeeOperationsController.showEmployeeReport()");
		 //Use Service
		 Page<Employee> page=empService.getEmployeesReportDataByPage(pageable);
		 //Put Result In Model Attribute
		 map.put("empsData", page);
		 //Return LVN
		 return "show_employee_report";
	 }
}
