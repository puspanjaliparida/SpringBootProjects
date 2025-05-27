//IEmployeeRepository.java(05.05.2025)
package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.EmployeeEntity;

public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    
	@Query("from EmployeeEntity where sal>=:start and sal<=:end")
	public Iterable<EmployeeEntity> findEmployeesBySalaryRange(double start,double end);
	
	@Query("delete from EmployeeEntity where sal>=:start and sal<=:end")
	@Modifying
	@Transactional
	public int removeEmployeeBySalaryRange(double start,double end);
}
