//IDoctorService.java(26/27/28/01/03/04.02/03.2025)
package com.nt.service;

import java.util.Optional;

import com.nt.entity.Doctor;

public interface IDoctorService {
     public String registerDoctor(Doctor doctor);
     public long showDoctorsCount();
     public String registerDoctorsAsGroup(Iterable<Doctor> list);
     public String checkDoctorAvailabilityById(int id);
     public Iterable<Doctor> findAllDoctors();
     public Iterable<Doctor> findAllDoctorsByIds(Iterable<Integer> ids);
     public Doctor showDoctorById(int id);
     public String fetchDoctorById(int id);
     public Optional<Doctor> getDoctorById(int id);
     public String registerOrUpdateDoctor(Doctor doctor);  //Full Object Modification
     public String updateDoctorDetails(int id, String newQlfy,Long newMobileNo);
     public String removeAllDoctors();
     public String removeDoctorsByIds(Iterable<Integer> ids);
     public String removeAllDoctors(Iterable<? extends Doctor> entities);
     public String removeDoctorById(int id);
}
