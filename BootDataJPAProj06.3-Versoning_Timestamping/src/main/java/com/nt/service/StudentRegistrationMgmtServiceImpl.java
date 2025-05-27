//StudentRegistrationMgmtServiceImpl.java(11.03.2025)
package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.StudentRegistrationInfo;
import com.nt.repository.IStudentRegistrationInfoRepo;

@Service
public class StudentRegistrationMgmtServiceImpl implements IStudentRegistrationMgmtService{
       @Autowired
       private IStudentRegistrationInfoRepo studentRepo;
       
       @Override
       public String saveStudentRegistrationInfo(StudentRegistrationInfo info) {
    	   Integer idVal=studentRepo.save(info).getStudentId();
    	   return "Student Is Saved With The Id Value::"+idVal;
       }
       
       @Override
       public String updateStudentRegistrationInfoById(Integer id,String studentName,String course,String batch) {
    	   Optional<StudentRegistrationInfo> opt=studentRepo.findById(id);
    	   if(opt.isPresent()) {
    		   StudentRegistrationInfo info=opt.get();
    		   info.setStudentName(studentName);
    		   info.setCourse(course);
    		   info.setBatch(batch);
    		   StudentRegistrationInfo tune=studentRepo.save(info);
    		 return "Object Is Updated For"+tune.getUpdatedCount()+"Times ... Lastly Modified On:"+tune.getLastlyUpdateOn()+" ... Created On ::"+tune.getServiceOptedOn();
    	   }
    	   else {
    		   return "StudentRegistrationService Is Not Found";
    	   }
       }
       
       @Override
       public StudentRegistrationInfo showStudentDetailsById(Integer id) {
    	   return studentRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Student Is  Not Found"));
       }
}
