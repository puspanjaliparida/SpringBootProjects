//HospitalServiceImpl.java(08/10/11.02.2025)
package com.nt.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IHospitalDAO;
import com.nt.model.Hospital;

@Service("hospitalService")
public class HospitalServiceImpl implements IHospitalService {
        
	@Autowired
	private IHospitalDAO dao;
	 
	//for retrieving hospital
	public List<Hospital> fetchAllHospitalByDegs(String degs1, String degs2,String degs3,String degs4,String degs5) throws Exception{		 
		//convert the designations into UPPERCASE LETTERS
		degs1=degs1.toUpperCase();
		degs2=degs2.toUpperCase();
		degs3=degs3.toUpperCase();
		degs4=degs4.toUpperCase();
		degs5=degs5.toUpperCase();
		
		System.out.println("Searching for hospitals in locations: " + Arrays.toString(new String[]{degs1, degs2, degs3, degs4, degs5}));
		//use DAO
		List<Hospital> list=dao.getHospitalByDegs(degs1, degs2, degs3,degs4,degs5);
		//sort the object in List collection
		list.sort((t1,t2)->t1.getHospitalid().compareTo(t2.getHospitalid()));
		return list;
	}//method
	
	//for inserting new hospital
	@Override
	public String registerHospital(Hospital hospital) throws Exception {
	    // Use DAO
	    int result = dao.insertHospital(hospital);
	    return result == 0 ? "Hospital not registered" : "Hospital is registered successfully";
	}

	@Override
	public String modifyHospital(Hospital hospital) throws Exception {
		 // Use DAO
	    int result = dao.updateHospital(hospital);
	    return result == 0 ? "Hospital not updated" : "Hospital is updated successfully";
	}

	 @Override
	    public String removeHospital(int hospitalId) throws Exception {
	        // Use DAO 
	        int result = dao.deleteHospital(hospitalId);
	        return result == 0 ? "Hospital not found or not deleted" : "Hospital is deleted successfully";
	    }
}//class
