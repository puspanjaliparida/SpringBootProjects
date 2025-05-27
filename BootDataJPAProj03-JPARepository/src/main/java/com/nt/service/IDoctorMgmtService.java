//IDoctorMgmtService.java(06.03.2025)
package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {
      public String removeAllDoctorsInBatch(Iterable<Integer> ids);
      public List<Doctor> findDoctorsByExampleData(Doctor doctor,boolean ascOrder,String ...props);
      public Doctor showDoctorById(int id);
      public Doctor fetchDoctorById(int id);
}
