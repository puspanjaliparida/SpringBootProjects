//EmployeeServiceImpl.java(08/10/11/12.02.2025)
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {
        
	@Autowired
	private IEmployeeDAO dao;
	
	public List<Employee> fetchAllEmployeesByDegs(String degs1, String degs2,String degs3) throws Exception{		 
		//convert the designations into UPPERCASE LETTERS
		degs1=degs1.toUpperCase();
		degs2=degs2.toUpperCase();
		degs3=degs3.toUpperCase();
		//use DAO
		List<Employee> list=dao.getEmployeesByDegs(degs1, degs2, degs3);
		//sort the object in List collection
		list.sort((t1,t2)->t1.getEno().compareTo(t2.getEno()));
		//calculate gross salary and net salary
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSalary()+(emp.getSalary()*0.5));
			emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.2));
		});
		return list;
	}//method
	
	//for inserting records
	@Override
	public String registerEmployee(Employee emp)throws Exception{
		//use DAO 
		int result=dao.insertEmployee(emp);
		return result==0?"Employee not registered":"Employee is registered";
	}
	
	//for updating records
	@Override
	public String modifyEmployee(Employee emp)throws Exception{
		// Use DAO 
	    int result = dao.updateEmployee(emp);
	    return result == 0 ? "Employee not updated" : "Employee is updated";	
	}
	
	//for deleting records
	@Override
	public String removeEmployee(int eno)throws Exception{
		//use DAO
		int result = dao.deleteEmployee(eno);
		return result == 0 ? "Employee is not deleted" : "Employee is deleted"; 
	}
}//class
