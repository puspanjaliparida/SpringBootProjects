//EmployeeMgmtServiceImpl.java(09/10.04.2025)
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
    @Autowired
	private IEmployeeRepository empRepo;

	@Override
	public Page<Employee> getEmployeesReportDataByPage(Pageable pageable) {
		return empRepo.findAll(pageable);
	}
}
