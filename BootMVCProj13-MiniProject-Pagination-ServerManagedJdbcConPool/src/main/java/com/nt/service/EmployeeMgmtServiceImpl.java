//EmployeeMgmtServiceImpl.java(13.04.2025)
package com.nt.service;

import javax.sql.DataSource;

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
    @Autowired
    private DataSource ds;

	@Override
	public Page<Employee> getEmployeesReportDataByPage(Pageable pageable) {
		System.out.println("DataSource Object Class Name::"+ds.getClass());
		return empRepo.findAll(pageable);
	}
}
