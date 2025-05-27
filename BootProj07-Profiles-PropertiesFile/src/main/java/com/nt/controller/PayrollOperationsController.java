//PayrollOperationsController.java(19.02.2025)
package com.nt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@Controller("payroll")
public class PayrollOperationsController {
        
	public PayrollOperationsController() {
		    System.out.println("PayrollOperationsController::0-Param Constructor");
	}

	@Autowired
	private IEmployeeService service;
	
	//For Retrieving Record
	public List<Employee> showAllEmployeesByDegs(String degs1,String degs2,String degs3) throws Exception{
		//Use Service
		List<Employee> list=service.fetchAllEmployeesByDegs(degs1,degs2,degs3);
		return list;
	}
	
	//For Inserting Record
	public String processEmployeeInsert(Employee emp)throws Exception{
		//Use Service
		String resultMsg=service.registerEmployee(emp);
		return resultMsg;
	}
	
	//For Updating Record
	public String processEmployeeUpdate(Employee emp) throws Exception {
	    //Use Service
	    String resultMsg = service.modifyEmployee(emp);
	    return resultMsg;
	}
	
	//For Deleting Record
	public String processEmployeeDelete(int empno)throws Exception{
		//Use Service
		String resultMsg = service.removeEmployee(empno);
		return resultMsg;
	}
}//Class
