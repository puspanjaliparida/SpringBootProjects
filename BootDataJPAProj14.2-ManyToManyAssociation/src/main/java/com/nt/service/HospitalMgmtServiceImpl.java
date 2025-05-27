//HospitalMgmtServiceImpl.java(21.03.2025)
package com.nt.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.repository.IDoctorRepository;
import com.nt.repository.IPatientRepository;

@Service
public class HospitalMgmtServiceImpl implements IHosptialMgmtService {
	  @Autowired
      private IDoctorRepository docRepo;
	  @Autowired
	  private IPatientRepository patRepo;
	  
	@Override
	public String saveDoctorsAndPatients(List<Doctor> list) {
		//Save Objects(Parent To Child)
		List<Doctor> savedList=docRepo.saveAll(list);
		//Get Saved Doctor Ids
		List<Integer> ids=savedList.stream().map(Doctor::getDid).collect(Collectors.toList());
		return ids+"Doctors And Their Patients Are Saved";
	}

	@Override
	public String savePatientsAndDoctors(List<Patient> list) {
		// Save Objects
		List<Patient> savedList=patRepo.saveAll(list);
		//Get The Ids Of Saved Objects
		List<Integer> ids=savedList.stream().map(Patient::getPatid).collect(Collectors.toList());
		return ids+"Patients And Their Doctors Are Saved";
	}

	@Override
	public List<Doctor> showDoctorsAndTheirPatients() {
		return docRepo.findAll();
	}

	@Override
	public List<Patient> showPatientsAndTheirDoctors() {
		return patRepo.findAll();
	}

	@Override
	public String removeCertainPatientsFromDoctor(int did, int pat1, int pat2) {
		// Load The Given Doctor
		Optional<Doctor> opt=docRepo.findById(did);
		if(opt.isPresent()) {
			Doctor doc=opt.get();
			//Get Patients Of The Doctor
			List<Patient> list=doc.getPatients();
			list.forEach(pat->{
				if(pat.getPatid()==pat1 || pat.getPatid()==pat2) {
					pat.setDoctors(null);
				}
			});
			//Update The Doctor Info
			docRepo.save(doc);
			return "Patients Are Removed From The Doctor";
		}
		return "Doctor Not Found";
	}
     
}
