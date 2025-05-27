//EmployeeDateTimeRepository.java(12.03.2025)
package com.nt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Employee_Date_Time;

public interface EmployeeDateTimeRepository extends JpaRepository<Employee_Date_Time, Integer> {

	@Query(nativeQuery=true,value="SELECT EXTRACT(YEAR FROM CURRENT_TIMESTAMP) - EXTRACT(YEAR FROM DOB) FROM EMPLOYEE_DATE_TIME WHERE DESG=:job")
	public List<Integer> getEmployeeAgesByDesg(String job);
	
	/*For Mysql
	 * @Query(value="SELECT (DATEDIFF(CURRENT_DATE, dob) / 365.25) FROM EMPLOYEE_DATE_TIME WHERE ENO=:eno",nativeQuery=true)
	 */
    @Query(value="SELECT EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM DOB) AS AGE FROM EMPLOYEE_DATE_TIME WHERE eno =:eno",nativeQuery=true)
	public float calculateAgeByEno(int eno);
}
