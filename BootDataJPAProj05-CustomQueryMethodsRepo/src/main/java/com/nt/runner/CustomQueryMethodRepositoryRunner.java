//CustomQueryMethodRepositoryRunner.java(08/10/11.03.2025)
package com.nt.runner;

//import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Component
public class CustomQueryMethodRepositoryRunner implements CommandLineRunner {

	@Autowired
	private IDoctorRepository docRepo;
	
	@Override
	public void run(String... args) throws Exception {
		/*List<Doctor> list=docRepo.showAllDoctors();
		list.forEach(System.out::println);*/
		
		//docRepo.showAllDoctorsBySpecialization("Cardio", "ortho", "neuro").forEach(System.out::println);
		
		/*System.out.println("Bulk Entity Query");
		docRepo.showDoctorsByIncome(5000.0, 8000.0).forEach(System.out::println);
		
		System.out.println("-----------------------------------");
		System.out.println("Bulk Scalar/Projection Query Selecting Specific Multiple Column Values");
		docRepo.showDoctorsDataByQualifications("MD","MD-FRC","MBBS").forEach(row->{
			for(Object obj:row) {
				System.out.println(obj+" ");
			}
			System.out.println();
		});
		System.out.println("-----------------------------------");
		
		System.out.println("Bulk Scalar/Projection Query Giving Single Column Value");
		docRepo.showDoctorsNameBySpecialization("Cardio").forEach(System.out::println);*/
		
		//Single Row Entity Query
		/*Doctor doctor=docRepo.showDoctorDetailsByName("Omm");
		if(doctor==null)
			System.out.println("Record Is Not Found");
		else
		System.out.println("Doctor Details::"+doctor);*/
		
		//Single Row Scalar Query(Specific Multiple Column Values)
		/*Object data=docRepo.showDoctorDataByName("Sai");
		if(data==null)
			System.out.println("Record Is Not Found");
		else {
		Object row[]=(Object[])data;
		System.out.println("Doctor Data::"+Arrays.toString(row));
		}*/
		
		//Single Row Scalar Query(Specific Single Column Value)
		/*Double income=docRepo.showDoctorIncomeByName("Raju");
		if(income==null)
			System.out.println("Record Is Not Found");
		else
		System.out.println("Income::"+income);
		
		long count=docRepo.showUniqueDoctorsCount();
		System.out.println("Unique Doctors Count::"+count);*/
		
		/*Object data=docRepo.showDoctorsAggregateData();
		Object row[]=(Object[]) data;
		System.out.println("Records Count::"+row[0]);
		System.out.println("Max Income::"+row[1]);
		System.out.println("Min Income::"+row[2]);
		System.out.println("Sum Of All Incomes::"+row[3]);
		System.out.println("Avg Of All Incomes::"+row[4]);*/
		
		/*int count=docRepo.updateDoctorsIncomeBySpecializations(10.0, "Ortho","Cardio");
		System.out.println("Modified Doctors Count::"+count);*/
		
		/*int count=docRepo.removeDoctorsByIncomeRange(2000.0,8000.0);
		System.out.println("No. Of Doctors That Are Removed::"+count);*/
		
		System.out.println("System Date And Time Is::"+docRepo.showSystemDateAndTime());
		System.out.println("----------------------------");
		docRepo.registerDoctor(215,"Rajesh",7878.0,"MD");
		System.out.println("----------------------------");
		docRepo.createTempTable();
	}//Run(-)
}//Class
