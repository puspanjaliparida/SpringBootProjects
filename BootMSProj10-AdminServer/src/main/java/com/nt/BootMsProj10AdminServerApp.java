//BootMsProj10AdminServerApp.java(22.05.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class BootMsProj10AdminServerApp {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj10AdminServerApp.class, args);
	}

}
