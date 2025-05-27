//IEmployeeMgmtService.java(14.04.2025)
package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	public List<Employee> showAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee getEmployeeByNo(int empno);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeById(int empno);
}
