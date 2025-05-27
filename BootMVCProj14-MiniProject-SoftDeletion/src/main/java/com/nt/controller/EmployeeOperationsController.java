//EmployeeOperationsController.java(14.04.2025)
package com.nt.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
	 
//	 @GetMapping("emp_report")
//	 public String showEmployeeReport(Map<String,Object> map) {
//		 //Use Service
//		 List<Employee> list=empService.showAllEmployees();
//		 //Put Result In Model Attribute
//		 map.put("empsList", list);
//		 //Return LVN
//		 return "show_employee_report";
//	 }
//	 
	 @GetMapping("/emp_add") 
	 public String showFormForSaveEmployee(@ModelAttribute("emp") Employee emp) {
		 //Return LVN
		 return "register_employee";
	 }
	 
	/* @PostMapping("/emp_add") //Problem Code
	 public String saveEmployee(@ModelAttribute("emp") Employee emp,
			                                                    Map<String, Object> map) {
		 //Use Service
		 String msg=empService.registerEmployee(emp);
		 List<Employee> list=empService.showAllEmployees();
		 //Keep The Result In ModelAttribute
		 map.put("resultMsg", msg);
		 map.put("empsList", list);
		 //Return LVN
		 return "show_employee_report";
	 }*/
	 
	/* @PostMapping("/emp_add") //Solution1-Implementing PRG Pattern 
	 public String saveEmployee(@ModelAttribute("emp") Employee emp,
			                                                  Map<String,Object> map) {
		 System.out.println("EmployeeOpeartionsController.saveEmployee()");
		 //Use Service
		 String msg=empService.registerEmployee(emp);
		 //Keep The Result In ModelAttribute
		 map.put("resultMsg", msg);
		 //Return LVN
		 return "redirect:emp_report";
	 }
	 
	 @GetMapping("/emp_report")
	 public String showEmployeeReport(Map<String, Object> map) {
		 System.out.println("EmployeeOperationsController.showEmployeeReport()");
		 //Use Service
		 List<Employee> list=empService.showAllEmployees();
		 //Put Result In Model Attribute
		 map.put("empsList", list);
		 //Return LVN
		 return "show_employee_report";
	 }*/
	 
	 /*@PostMapping("/emp_add") //Solution3-Implementing PRG Pattern 
	 public String saveEmployee(@ModelAttribute("emp") Employee emp,
			                                                  HttpSession ses) {
		 System.out.println("EmployeeOperationsController.saveEmployee()");
		 //Use Service
		 String msg=empService.registerEmployee(emp);
		 //Keep The Result In ModelAttribute
		 ses.setAttribute("resultMsg", msg);
		 //Return LVN
		 return "redirect:emp_report";
	 }*/
	 
	 @PostMapping("/emp_add") //Solution2-Implementing PRG Pattern 
	 public String saveEmployee(@ModelAttribute("emp") Employee emp,
			                                                  RedirectAttributes attrs) {
		 System.out.println("EmployeeOperationsController.saveEmployee()");
		 //Use Service
		 String msg=empService.registerEmployee(emp);
		 //Keep The Result In ModelAttribute
		 attrs.addFlashAttribute("resultMsg", msg);
		 //Return LVN
		 return "redirect:emp_report";
	 }
	 
	 @GetMapping("/emp_report")
	 public String showEmployeeReport(Map<String, Object> map) {
		 System.out.println("EmployeeOperationsController.showEmployeeReport()");
		 //Use Service
		 List<Employee> list=empService.showAllEmployees();
		 //Put Result In Model Attribute
		 map.put("empsList", list);
		 //Return LVN
		 return "show_employee_report";
	 }
	 
	 @GetMapping("/emp_edit")
	 public String showEditEmployeeFormPage(@RequestParam("no") int no,
			                                                                                @ModelAttribute("emp") Employee emp) {
		 //Use Service
		 Employee emp1=empService.getEmployeeByNo(no);
		 //Copy Data
		 BeanUtils.copyProperties(emp1, emp);
		 //Return LVN
		 return "update_employee";
	 }
	 
	 @PostMapping("/emp_edit")
	 public String editEmployee(RedirectAttributes attrs,
			                                               @ModelAttribute("emp") Employee emp) {
		 //Use Service
		 String msg=empService.updateEmployee(emp);
		 //Add The Result Message As Flash Attribute
		 attrs.addFlashAttribute("resultMsg",msg);
		 //Redirect The Redirect
		 return "redirect:emp_report";
	 }
	 
	 @GetMapping("/emp_delete")
	 public String deleteEmployee(RedirectAttributes attrs,@RequestParam int no) {
		 //Use Service
		 String msg=empService.deleteEmployeeById(no);
		 //Keep The Result In FlashAttribute
		 attrs.addFlashAttribute("resultMsg",msg);
		 //Redirect The Request
		 return "redirect:emp_report";
	 }
}
