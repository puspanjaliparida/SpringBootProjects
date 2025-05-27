//ICollegeMgmtService.java(21/22.03.2025)
package com.nt.service;

import java.util.List;

import com.nt.entity.Faculty;
import com.nt.entity.Student;

public interface ICollegeMgmtService {
      public String registerDetailsUsingFacultiesInfo(List<Faculty> list);//Parent To Child
      public String registerFacultiesUsingStudentsInfo(List<Student> list);//Child To Parent
      public List<Faculty> showFacultiesAndTheirStudents();//Parent To Child
      public List<Student> showStudentsAndTheirFaculties();//Child To Parent
      
      public String removeCertainStudentsFromFaculties(int fid,int stud1,int stud2);
}
