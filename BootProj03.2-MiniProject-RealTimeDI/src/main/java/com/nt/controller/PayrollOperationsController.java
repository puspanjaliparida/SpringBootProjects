//PayrollOperationsController.java(12.02.2025)
package com.nt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Hospital;
import com.nt.service.IHospitalService;

@Controller("payroll")
public class PayrollOperationsController {
         
	@Autowired
	private IHospitalService service;
	
	public List<Hospital> showAllHospitalByDegs(String degs1,String degs2,String degs3,String degs4,String degs5) throws Exception{
		//Use Service
		List<Hospital> list=service.fetchAllHospitalByDegs(degs1,degs2,degs3,degs4,degs5);
		return list;
	}//Method
	
	public String processHospitalRegistration(Hospital hospital) throws Exception {
	    String resultMsg = service.registerHospital(hospital);
	    return resultMsg;
	}
	
	public String processHospitalUpdate(Hospital hospital) throws Exception {
	    String resultMsg = service.modifyHospital(hospital);
	    return resultMsg;
	}
	
	public String processHospitalDelete(int hospitalId) throws Exception {
        // Use Service
        String resultMsg = service.removeHospital(hospitalId);
        return resultMsg;
    }
}//Class
