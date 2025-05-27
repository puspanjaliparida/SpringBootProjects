//EmployeeServiceImpl.java(14.02.2025)
package com.nt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {
        
	@Autowired
	@Qualifier("empPostgreSQLDAO")
	private IEmployeeDAO empDAO;
	
	public List<Employee> fetchAllEmployeesByDegs(String degs1, String degs2,String degs3) throws Exception{		 
		//Convert The Designations Into UPPERCASE LETTERS
		degs1=degs1.toUpperCase();
		degs2=degs2.toUpperCase();
		degs3=degs3.toUpperCase();
		//Use DAO
		List<Employee> list=empDAO.getEmployeesByDegs(degs1, degs2, degs3);
		//Sort The Object In List Collection
		list.sort((t1,t2)->t1.getEmpno().compareTo(t2.getEmpno()));
		return list;
	}//Method
	
	//For Inserting Records
	@Override
	public String registerEmployee(Employee emp)throws Exception{
		//Use DAO 
		int result=empDAO.insertEmployee(emp);
		return result==0?"Employee Is Not Registered":"Employee Is  Registered";
	}
	
	//For Updating Records
	@Override
	public String modifyEmployee(Employee emp)throws Exception{
		// Use DAO 
	    int result = empDAO.updateEmployee(emp);
	    return result == 0 ? "Employee Is Not Updated" : "Employee Is Updated";	
	}
	
	//For Deleting Records
	@Override
	public String removeEmployee(int eno)throws Exception{
		//Use DAO
		int result = empDAO.deleteEmployee(eno);
		return result == 0 ? "Employee Is not Deleted" : "Employee Is Deleted"; 
	}
}//Class
