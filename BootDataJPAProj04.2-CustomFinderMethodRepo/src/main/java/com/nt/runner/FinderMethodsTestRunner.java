//FinderMethodsTestRunner.java(07.03.2025)
package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.nt.entity.JobSeeker;
import com.nt.repository.IJobSeekerRepository;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner{

	@Autowired
	private IJobSeekerRepository jsRepo;
	
	@Override
	public void run(String... args) throws Exception {
//		List<JobSeeker> list=jsRepo.findByJsNameEquals("Omm");
//		list.forEach(System.out::println);
		
		jsRepo.readByJsName("Bablu").forEach(System.out::println);
		System.out.println("--------------------");
		jsRepo.getByJsNameIs("Mama").forEach(System.out::println);
		System.out.println("--------------------");
		jsRepo.findByPercentageBetween(45.0,89.0).forEach(System.out::println);
		System.out.println("--------------------");
		jsRepo.findByJsNameStartingWith("M").forEach(System.out::println);
		System.out.println("--------------------");
		jsRepo.findByJsNameEndingWithIgnoreCase("O").forEach(System.out::println);
		System.out.println("--------------------");
		jsRepo.findByJsNameContainingIgnoreCase("ba").forEach(System.out::println);
		System.out.println("--------------------");
		jsRepo.findByJsNameLikeIgnoreCase("o%").forEach(System.out::println);
		System.out.println("---------------------");
		jsRepo.findByJsNameLikeIgnoreCase("%a").forEach(System.out::println);
        System.out.println("---------------------");
        jsRepo.findByJsNameLikeIgnoreCase("%lu").forEach(System.out::println);
        System.out.println("---------------------");
        jsRepo.findByQlfyIn(List.of("Btech","Mtech")).forEach(System.out::println);
        System.out.println("---------------------");
        jsRepo.readByMobileNoIsNull().forEach(System.out::println);
        System.out.println("---------------------");
        jsRepo.findByQlfyInOrderByQlfyAsc(List.of("Btech","Iti","Diploma")).forEach(System.out::println);
	}

}
