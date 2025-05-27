//IJobSeekerRepository.java(07.03.2025)
package com.nt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.JobSeeker;

public  interface IJobSeekerRepository extends JpaRepository<JobSeeker,Integer>{
      public List<JobSeeker> findByJsNameEquals(String name);
      public List<JobSeeker> getByJsNameIs(String name);
      public List<JobSeeker> readByJsName(String name);
      public List<JobSeeker> findByPercentageBetween(double start,double end);
      public List<JobSeeker> findByJsNameStartingWith(String nameInitialChars);
      public List<JobSeeker> findByJsNameEndingWithIgnoreCase(String nameLastChars);
      public List<JobSeeker> findByJsNameContainingIgnoreCase(String chars);
      public List<JobSeeker> findByJsNameLikeIgnoreCase(String pattern);
      public List<JobSeeker> findByQlfyIn(List<String> qualifications);
      public List<JobSeeker> readByMobileNoIsNull();
      public List<JobSeeker> findByQlfyInOrderByQlfyAsc(List<String> qualifications);
}
