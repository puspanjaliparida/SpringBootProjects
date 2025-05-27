//ManyToManyAssociationTestRunner.java(21.03.2025)
package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.service.IHosptialMgmtService;

@Component
public class ManyToManyAssociationTestRunner implements CommandLineRunner {
    @Autowired
	private IHosptialMgmtService hospitalService;
    
	@Override
	public void run(String... args) throws Exception {
		/*try {
			//Prepare Parent Objects
			Doctor doc1=new Doctor();
			doc1.setName("Raja");
			doc1.setSpecialization("Cardio");
			
			Doctor doc2=new Doctor();
			doc2.setName("Karan");
			doc2.setSpecialization("Neuro");
			
			Patient pat1=new Patient();
			pat1.setPname("Ramesh");
			pat1.setProblem("heart");
			
			Patient pat2=new Patient();
			pat2.setPname("Naresh");
			pat2.setProblem("brain");
			
			Patient pat3=new Patient();
			pat3.setPname("Rajesh");
			pat3.setProblem("stomach");
			
			doc1.setPatients(List.of(pat1,pat2));
			doc2.setPatients(List.of(pat1,pat2,pat3));
			
			//Invoke The Method
			String msg=hospitalService.saveDoctorsAndPatients(List.of(doc1,doc2));
			System.out.println(msg);
		}//Try
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			//Prepare Parent Objects
			Doctor doc1=new Doctor();
			doc1.setName("Mahesh");
			doc1.setSpecialization("pulamalogist");
			
			Doctor doc2=new Doctor();
			doc2.setName("Nikhil");
			doc2.setSpecialization("Ortho");
			
			Patient pat1=new Patient();
			pat1.setPname("Madhu");
			pat1.setProblem("Knee Pain");
			
			Patient pat2=new Patient();
			pat1.setPname("Rani");
			pat1.setProblem("hand");
			
			Patient pat3=new Patient();
			pat1.setPname("Mukesh");
			pat1.setProblem("throat");
			
			pat1.setDoctors(List.of(doc1,doc2));
			pat2.setDoctors(List.of(doc1));
			pat3.setDoctors(List.of(doc1,doc2));
			
			//Invoke The Method
			String msg=hospitalService.savePatientsAndDoctors(List.of(pat1,pat2,pat3));
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			hospitalService.showDoctorsAndTheirPatients().forEach(doc->{
				System.out.println("Parent::"+doc);
				//Get Childs Of Each Parent
				List<Patient> list=doc.getPatients();
				list.forEach(pat->{
					System.out.println("Child::"+pat);
				});
			});
		}//Try
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			hospitalService.showPatientsAndTheirDoctors().forEach(pat->{
				System.out.println("Child::"+pat);
				List<Doctor> list=pat.getDoctors();
				list.forEach(doc->{
					System.out.println("Parent::"+doc);
				});
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			String msg=hospitalService.removeCertainPatientsFromDoctor(1002, 1024, 1025);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
