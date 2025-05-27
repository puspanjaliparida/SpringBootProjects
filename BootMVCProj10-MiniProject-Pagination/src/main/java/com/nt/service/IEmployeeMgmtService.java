//IEmployeeMgmtService.java(09/10.04.2025)
package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	public Page<Employee> getEmployeesReportDataByPage(Pageable pageable);
}
