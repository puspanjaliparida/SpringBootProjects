//BootSchedulingProj01Application.java(12/13.04.2025)
package com.nt;

import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootSchedulingProj01Application {

	public static void main(String[] args) {
		SpringApplication.run(BootSchedulingProj01Application.class, args);
		System.out.println("Application Started At::"+new Date()+Thread.currentThread().getName());
	}

}
