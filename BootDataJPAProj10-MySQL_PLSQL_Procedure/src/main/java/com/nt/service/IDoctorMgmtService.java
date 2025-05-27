//IDoctorMgmtService.java(14.03.2025)
package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {
     public List<Doctor> showDoctorsByIncomeRange(double start,double end);
}
