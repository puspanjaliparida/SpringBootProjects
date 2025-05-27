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
	 
	//For Retrieving Hospital
	public List<Hospital> fetchAllHospitalByDegs(String degs1, String degs2,String degs3,String degs4,String degs5) throws Exception{		 
		//Convert The Designations Into UPPERCASE LETTERS
		degs1=degs1.toUpperCase();
		degs2=degs2.toUpperCase();
		degs3=degs3.toUpperCase();
		degs4=degs4.toUpperCase();
		degs5=degs5.toUpperCase();
		
		System.out.println("Searching For Hospitals In Locations: " + Arrays.toString(new String[]{degs1, degs2, degs3, degs4, degs5}));
		//Use DAO
		List<Hospital> list=dao.getHospitalByDegs(degs1, degs2, degs3,degs4,degs5);
		//Sort The Object In List Collection
		list.sort((t1,t2)->t1.getHospitalid().compareTo(t2.getHospitalid()));
		return list;
	}//Method
	
	//For Inserting New Hospital
	@Override
	public String registerHospital(Hospital hospital) throws Exception {
	    // Use DAO
	    int result = dao.insertHospital(hospital);
	    return result == 0 ? "Hospital Is  Not Registered" : "Hospital Is Registered Successfully";
	}

	@Override
	public String modifyHospital(Hospital hospital) throws Exception {
		 // Use DAO
	    int result = dao.updateHospital(hospital);
	    return result == 0 ? "Hospital Is Not Updated" : "Hospital Is Updated Successfully";
	}

	 @Override
	    public String removeHospital(int hospitalId) throws Exception {
	        // Use DAO 
	        int result = dao.deleteHospital(hospitalId);
	        return result == 0 ? "Hospital Is Not Found or Not Deleted" : "Hospital Is Deleted Successfully";
	    }
}//Class
