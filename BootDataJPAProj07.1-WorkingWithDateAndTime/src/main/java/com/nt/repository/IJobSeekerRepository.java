//IJobSeekerRepository.java(12.03.2025)
package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.JobSeeker;

public interface IJobSeekerRepository extends JpaRepository<JobSeeker, Integer> {

	//@Query(value="SELECT TRUNC(MONTHS_BETWEEN(sysdate,dob)/ 12) FROM JOBSEEKER_JODA WHERE js_id=:id",nativeQuery=true)
	@Query(value="SELECT (SYSDATE-TO_DATE(to_char(dob,'dd-MON-yyyy'),'dd-MON-yyyy'))/365.25 FROM JOBSEEKER_JODA WHERE js_id=:id",nativeQuery=true)
	public double findJsAgeById(int id);
}
