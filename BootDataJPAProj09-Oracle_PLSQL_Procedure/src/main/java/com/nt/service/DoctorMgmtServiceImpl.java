//DoctorMgmtServiceImpl.java(14.03.2025)
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {

	@Autowired
	private EntityManager manager;

	@Override
	public List<Doctor> showDoctorsByIncomeRange(double start, double end) {
		//Create StoredProcedureQuery Object Pointing PL/SQL Procedure
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_DOCTORS_BY_INCOME_RANGE",Doctor.class);
		//Register Both IN,OUT Params By Specifying Their Mode
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Object.class, ParameterMode.REF_CURSOR);
		//Set Values To IN Params
		query.setParameter(1, start);
		query.setParameter(2, end);
		//Call PL/SQL Procedure
		List<Doctor> list=query.getResultList();
		return list;
	}
}
