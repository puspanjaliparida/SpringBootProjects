//IStudentRegistrationMgmtService.java(11.03.2025)
package com.nt.service;

import com.nt.entity.StudentRegistrationInfo;

public interface IStudentRegistrationMgmtService {
      public String saveStudentRegistrationInfo(StudentRegistrationInfo info);
      public String updateStudentRegistrationInfoById(Integer id,String studentName,String course,String batch);
      public StudentRegistrationInfo showStudentDetailsById(Integer id);
}
