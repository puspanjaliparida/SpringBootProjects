//EmployeeMgmtServiceImpl.java(16.04.2025)
package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
    @Autowired
	private IEmployeeRepository empRepo;
    
	@Override
	public List<Employee> showAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
		return "Employee Is Saved With Id Value::"+empRepo.save(emp).getEmpno();
	}

	@Override
	public Employee getEmployeeByNo(int empno) {
		Employee emp=empRepo.findById(empno).orElseThrow(()->new IllegalArgumentException());
		return emp;
	}

	@Override
	public String updateEmployee(Employee emp) {
		System.out.println(emp.getEmpno());
		Optional<Employee> opt=empRepo.findById(emp.getEmpno());
		if(opt.isPresent()) {
			Employee emp1=opt.get();
			emp.setUpdateCount(emp1.getUpdateCount());
		    emp.setUpdatedBy(System.getProperty("user.name"));
		    empRepo.save(emp);
		    return emp.getEmpno()+"  Employee Data Is Modified";
		}
		return emp.getEmpno()+"Employee Is Not Found";
	}

	@Override
	public String deleteEmployeeById(int empno) {
		empRepo.deleteById(empno);
		return empno+"Employee Id Employee Is Deleted";
	}
}
