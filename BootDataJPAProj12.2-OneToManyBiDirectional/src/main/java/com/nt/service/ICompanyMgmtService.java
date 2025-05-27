//ICompanyMgmtService.java(19.03.2025)
package com.nt.service;

import java.util.List;
import java.util.Set;

import com.nt.entity.Department;
import com.nt.entity.Employee;

public interface ICompanyMgmtService {
       public String registerDepartment(Department dept); //Parent To Child Saving
       public String registerEmployees(Set<Employee> emps); //Child To Parent Saving
       
       public List<Department> showAllDepartmentsAndItsEmployees(); //Parent To Child Loading
       public List<Employee> showAllEmployeesAndItsDepartments(); //Child To Parent Loading
       public String removeDepartmentAndItsEmployees(int dno);
       public String removeEmployeesAndTheirDepartment(List<Integer> empIds);
       public String addNewEmployeeToDepartment(int dno,Employee emp);
       public String removeAllEmployeesOfADepartment(int dno);
       public String removeOneEmployeeOfADepartment(int dno,int empno);
}
