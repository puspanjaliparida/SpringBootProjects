//IStudentRegistrationInfoRepo.java(11.03.2025)
package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nt.entity.StudentRegistrationInfo;

public interface IStudentRegistrationInfoRepo extends JpaRepository<StudentRegistrationInfo,Integer>{

}
