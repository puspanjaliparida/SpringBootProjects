//IEmployeeMgmtService.java(05.05.2025)
package com.nt.service;

import com.nt.vo.EmployeeVO;

public interface IEmployeeMgmtService {
     public String insertEmployee(EmployeeVO empVO);
     public String insertEmployeesBatch(Iterable<EmployeeVO> empsVO);
     public Iterable<EmployeeVO> showAllEmployees();
     public EmployeeVO showEmployeesByEmpno(int empno);
     public Iterable<EmployeeVO> showEmployeesBySalaryRange(double startSal,double endSal);
     public String updateEmployee(EmployeeVO vo);
     public String updateEmployeeSalaryByEmpno(int empno,double hikePercentage);
     public String removeEmployeesByEmpno(int empno);
     public String deleteEmployeesBySalaryRange(double start,double end);
}
