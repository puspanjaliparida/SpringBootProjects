//EmployeeMgmtServiceImpl.java(12.03.2025)
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee_Date_Time;
import com.nt.repository.EmployeeDateTimeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
     @Autowired
     private EmployeeDateTimeRepository empRepo;
	@Override
	public String saveEmployee(Employee_Date_Time dateTime) {
		int idVal=empRepo.save(dateTime).getEno();
		return "Employee Object Is Saved With The Id Value::"+idVal;
	}

	@Override
	public List<Employee_Date_Time> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public List<Integer> showEmployeeAgesByDegs(String desg) {
		return empRepo.getEmployeeAgesByDesg(desg);
	}

	@Override
	public float getAgeByEno(int eno) {
		return empRepo.calculateAgeByEno(eno);
	}
}
