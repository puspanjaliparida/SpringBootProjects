//PagingAndSortingRepositoryRunner.java(06.03.2025)
package com.nt.runner;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class JPARepositoryRunner implements CommandLineRunner {

	@Autowired
	private IDoctorMgmtService docService;
	
	@Override
	public void run(String... args) throws Exception {
//        try {
//        	String msg=docService.removeAllDoctorsInBatch(List.of(210,211,567,215,278));
//            System.out.println(msg);
//        }
//        catch(Exception e) {
//        	e.printStackTrace();
//        }
		
//		try {
//			Doctor doc=new Doctor();
//			doc.setSpecialization("ortho");
//			doc.setQlfy("MBBS");
//			//Use Service
//			List<Doctor> list=docService.findDoctorsByExampleData(doc, true, "docName");
//			list.forEach(System.out::println);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			Doctor doctor=docService.showDoctorById(214);    
//		    System.out.println(doctor);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			Doctor doctor=docService.fetchDoctorById(102);
		    System.out.println("Class Name Of The Object::"+doctor.getClass());
		    System.out.println("Doctor Id::"+doctor.getDocId());
		    System.out.println("Get Doctor Name::"+doctor.getDocName());
		    System.out.println("Get Doctor Specialization::"+doctor.getSpecialization());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//Run(-)
}//Class
