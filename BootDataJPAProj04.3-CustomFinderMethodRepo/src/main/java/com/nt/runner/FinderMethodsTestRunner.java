//FinderMethodsTestRunner.java(07.03.2025)
package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IMovieRepo;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner{

	@Autowired
	private IMovieRepo movRepo; //InMemory Proxy Class Object Of Our Repository(I) Will Be Injected
	
	@Override
	public void run(String... args) throws Exception {
		//=========Finder Methods==============
		movRepo.findByMovNameEquals("Don").forEach(System.out::println);
		System.out.println("---------------------------");
		movRepo.findByMovNameIs("Mrs").forEach(System.out::println);
		System.out.println("---------------------------");
		movRepo.findByMovName("Dangal").forEach(System.out::println);
		System.out.println("--------------------------");
		movRepo.findByMovNameStartingWith("J").forEach(System.out::println);
		System.out.println("--------------------------");
		movRepo.findByMovNameEndingWith("l").forEach(System.out::println);
		System.out.println("--------------------------");
		movRepo.findByMovNameContaining("hub").forEach(System.out::println);
		System.out.println("--------------------------");
		movRepo.findByMovNameEqualsIgnoreCase("str").forEach(System.out::println);
		System.out.println("--------------------------");
		movRepo.findByMovNameContainingIgnoreCase("For").forEach(System.out::println);
	}

}
