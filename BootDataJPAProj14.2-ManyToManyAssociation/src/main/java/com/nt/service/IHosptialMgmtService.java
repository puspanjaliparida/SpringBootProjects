//IHosptialMgmtService.java(21.03.2025)
package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;

public interface IHosptialMgmtService {
     public String saveDoctorsAndPatients(List<Doctor> list);//Parent To Child
     public String savePatientsAndDoctors(List<Patient> list);//Child To Parent
     public List<Doctor> showDoctorsAndTheirPatients();//Parent To Child
     public List<Patient> showPatientsAndTheirDoctors();//Child To Parent
     
     public String removeCertainPatientsFromDoctor(int did,int pat1,int pat2);
}
