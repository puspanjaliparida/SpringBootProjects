//IEmployeeDAO.java(Interface)(20.02.2025)
package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {
        public List<Employee> getEmployeesByDegs(String degs1,String degs2,String degs3) throws Exception;
        public int insertEmployee(Employee emp)throws Exception;
        public int updateEmployee(Employee emp)throws Exception;
        public int deleteEmployee(int empno)throws Exception;
}
