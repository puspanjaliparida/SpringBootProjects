//DoctorMgmtServiceImpl.java(06.03.2025)
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {

	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public String removeAllDoctorsInBatch(Iterable<Integer> ids) {
		//Load The Objects Based On Based Ids
		List<Doctor> list=doctorRepo.findAllById(ids);
		//Get The Available Doctors Count
		int count=list.size();
		//Delete The Objects In Batch
		doctorRepo.deleteAllByIdInBatch(ids);
		return count+"No. Of Records Are Deleted";
	}

	@Override
	public List<Doctor> findDoctorsByExampleData(Doctor doctor, boolean ascOrder, String... props) {
		//Prepare Example Object
		Example<Doctor> example=Example.of(doctor);
		//Prepare Sort Object
		Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC,props);
		//Use Repo
		List<Doctor> list=doctorRepo.findAll(example);
		return list;
	}

	@Override
	public Doctor showDoctorById(int id) {
		//Use Repo
		Doctor doctor=doctorRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
		return doctor;
	}

	@Override
	@Transactional
	public Doctor fetchDoctorById(int id) {
		Doctor doctor=doctorRepo.getReferenceById(id);
		System.out.println(doctor.getClass()+"-----"+doctor.getClass().getSuperclass());		
		return doctor;
	}
}
