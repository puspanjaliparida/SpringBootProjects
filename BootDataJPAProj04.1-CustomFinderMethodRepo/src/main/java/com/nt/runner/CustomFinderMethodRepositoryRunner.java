//PagingAndSortingRepositoryRunner.java(07.03.2025)
package com.nt.runner;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Component
public class CustomFinderMethodRepositoryRunner implements CommandLineRunner {

	@Autowired
	private IDoctorRepository docRepo;
	
	@Override
	public void run(String... args) throws Exception {
          /* List<Doctor> list=docRepo.findBySpecializationEquals("cardio");
           list.forEach(System.out::println);*/
           
           /*List<Doctor> list=docRepo.readBySpecializationEquals("cardio");
           list.forEach(System.out::println);*/
           
           /*List<Doctor> list=docRepo.getBySpecializationEquals("cardio");
           list.forEach(System.out::println);*/
		
		   /*List<Doctor> list=docRepo.findBySpecializationIs("cardio");
	       list.forEach(System.out::println);*/
           
		   //docRepo.findBySpecialization("physio").forEach(System.out::println);
		
		 /*docRepo.findByDocNameStartingWith("R").forEach(System.out::println);
		 System.out.println("--------------------");
		 docRepo.findByDocNameEndingWith("u").forEach(System.out::println);
		 System.out.println(("--------------------"));
		 docRepo.findByDocNameContaining("m").forEach(System.out::println);*/
		
		/*docRepo.findByDocNameLike("%m").forEach(System.out::println);
		System.out.println("----------------------");
		docRepo.findByDocNameLike("o%").forEach(System.out::println);
		System.out.println("----------------------");
		docRepo.findByDocNameLike("%s%").forEach(System.out::println);*/
	   
		//docRepo.findByIncomeBetween(200000.0,700000.0).forEach(System.out::println);
		
		//docRepo.findByIncomeGreaterThanAndIncomeLessThan(5000.0,9000.0).forEach(System.out::println);
	
	   //docRepo.findBySpecializationEqualsIgnoreCase("cardio").forEach(System.out::println);
	
		docRepo.findBySpecializationEqualsIgnoreCaseOrderByDocNameAsc("cardio").forEach(System.out::println);
	}//Run(-)
}//Class
