//DoctorMgmtServiceImpl.java(26/27/28/01/03/04.02/03.2025)
package com.nt.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
//import com.nt.exception.DoctorNotFoundException;
import com.nt.repository.IDoctorRepo;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorService{

	@Autowired
	private IDoctorRepo doctorRepo; //Injects The Dynamically InMemory Proxy Class Object
	
	@Override
	public String registerDoctor(Doctor doctor) {
//		System.out.println("Repository Object Class Name(InMemory Proxy Class Name)::"+doctorRepo.getClass().getName());
//		System.out.println("List Of Implemented Interfaces::"+Arrays.toString(doctorRepo.getClass().getInterfaces()));
//		System.out.println("List Of Methods ::"+Arrays.toString(doctorRepo.getClass().getDeclaredMethods()));
		//Save The Object (Insert The Record
		   Doctor savedDoctor=doctorRepo.save(doctor);
		   //Get The Generated Id Value
		   int idVal=savedDoctor.getDocId();
		return "Doctor Object Is Saved With Id Value :"+idVal;
	}
	
	@Override
	public long showDoctorsCount() {
		long count=doctorRepo.count();
	return count;
	}
	
	@Override
	public String registerDoctorsAsGroup(Iterable<Doctor> list) {
		
		//Save The Objects
		Iterable<Doctor> savedList=doctorRepo.saveAll(list);
		//Collect Only Id Values From The SavedList Of Object
		List<Integer> ids=StreamSupport.stream(savedList.spliterator(),false).map(Doctor::getDocId).collect(Collectors.toList());
		return ids.size()+"No. Of Doctors Are Saved With Id Values::"+ids;
		//Get Saved Objects Count
//		List<Doctor> savedList1=(List<Doctor>)savedList;
//		int count=savedList1.size();
//		//Get Only Id Values From The SavedList
//		List<Integer> ids=new ArrayList<>();
//		savedList1.forEach(doc->{
//			ids.add(doc.getDocId());
//		});
//		return count+"No. Of Doctors Are Saved With Id Values::"+ids;
	}
	
	@Override
	public String checkDoctorAvailabilityById(int id) {
		boolean flag=doctorRepo.existsById(id);
		return flag?id+" Id Value Doctor Found":"Doctor Not  Found";
	}
	
	@Override
	public Iterable<Doctor> findAllDoctors() {
		return doctorRepo.findAll();
	}
	
	@Override
	public Iterable<Doctor> findAllDoctorsByIds(Iterable<Integer> ids){
		return doctorRepo.findAllById(ids);
	}

//	@Override
//	public Doctor showDoctorById(int id) {
//		Optional<Doctor> opt=doctorRepo.findById(id);
//		if(opt.isPresent()) {
//			//Get The Object
//			Doctor doc=opt.get();
//			return doc;
//		}
//		throw new IllegalArgumentException("Invalid Doctor Id");
//	}
	
//	    @Override
//	    public Doctor showDoctorById(int id) {
//			return doctorRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id"));
//	    }
	
//	       @Override
//            public Doctor showDoctorById(int id) {
//	    	   return doctorRepo.findById(id).orElseThrow(()-> new DoctorNotFoundException("Invalid Id"));
//	       }
	       
	  @Override
      public Doctor showDoctorById(int id) {
  	         return doctorRepo.findById(id).orElse(new Doctor(1111,"RAJA",7853L,"MBBS",356784891L,"Duty-Doctor"));
     }

		@Override
		public String fetchDoctorById(int id) {
			//Load The Object
			Optional<Doctor> opt=doctorRepo.findById(id);
			if(opt.isPresent()) {
				Doctor doc=opt.get();
				return id+" Doctor Id Details Are"+doc;
			}
			else {
				return id+"Doctor Is Not Found";
			}
		}

		@Override
		public Optional<Doctor> getDoctorById(int id) {
			Optional<Doctor> opt=doctorRepo.findById(id);
			if(opt.isEmpty())
			          return Optional.empty();
			else
				return opt;
		}

		@Override
		public String registerOrUpdateDoctor(Doctor doctor) {
			doctorRepo.save(doctor);			
			return "Doctor Is Saved/Updated";
		}

		@Override
		public String updateDoctorDetails(int id, String newQlfy, Long newMobileNo) {
			Optional<Doctor> opt=doctorRepo.findById(id);
			if(opt.isPresent()) {
				//Get Object
				Doctor doc=opt.get();
				//Set New Data
				doc.setQlfy(newQlfy);
				doc.setMobileNo(newMobileNo);
				doctorRepo.save(doc);
			    return "Doctor Details Are Updated";
			}
			return "Doctor Is Not Found For Updation";
		}

		@Override
		public String removeAllDoctors() {
			long count=doctorRepo.count();
			if(count>0) {
				doctorRepo.deleteAll();
				return count+"No. Of Records Are Deleted";
			}
			return "No. Of Records Found For Deletion";
		}

		@Override
		public String removeDoctorsByIds(Iterable<Integer> ids) {
			//Load The Objects By Ids
			Iterable<Doctor> list=doctorRepo.findAllById(ids);
			long count=StreamSupport.stream(list.spliterator(), false).count();
			
			//Delete Objects By Ids
			doctorRepo.deleteAllById(ids);
			return count+"No. Of Doctors Are Deleted";
		}
		
		@Override
		public String removeAllDoctors(Iterable<? extends Doctor> entities) {
		    // Count The Number Of Doctors To Be Deleted
		    long count = StreamSupport.stream(entities.spliterator(), false).count();

		    // Delete All Provided Doctor Entities
		    doctorRepo.deleteAll(entities);

		    return count + " No. Of Doctors Are Deleted";
		}

		@Override
		public String removeDoctorById(int id) {
		     Optional<Doctor> opt=doctorRepo.findById(id);
		     if(opt.isPresent()) {
		    	 doctorRepo.deleteById(id);
		    	 return id+"Doctor Found And Deleted";
		     }
		     else {
		    	 return id+"Doctor Is Not Found For Deletion";
		     }
		}
}
