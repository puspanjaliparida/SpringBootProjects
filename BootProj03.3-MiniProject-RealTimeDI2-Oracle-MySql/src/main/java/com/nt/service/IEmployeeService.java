//IEmployeeService.java(Interface)(13.02.2025)
package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeService {
        public List<Employee> fetchAllEmployeesByDegs(String degs1,String degs2,String degs3) throws Exception;
        public String registerEmployee(Employee emp)throws Exception;
        public String modifyEmployee(Employee emp)throws Exception;
        public String removeEmployee(int empno)throws Exception;
}
