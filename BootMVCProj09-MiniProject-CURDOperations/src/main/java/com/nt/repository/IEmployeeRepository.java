//IEmployeeRepository.java(05/07/08/09.04.2025)
package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
