//IEmployeeMgmtService.java(12.03.2025)
package com.nt.service;

import java.util.List;

import com.nt.entity.Employee_Date_Time;

public interface IEmployeeMgmtService {
     public String saveEmployee(Employee_Date_Time dateTime);
     public List<Employee_Date_Time> getAllEmployees();
     public List<Integer> showEmployeeAgesByDegs(String desg);
     public float getAgeByEno(int eno);
}
