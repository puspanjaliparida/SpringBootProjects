//BootMsProj07ConfigServerApp.java(19.05.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BootMsProj07ConfigServerApp {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj07ConfigServerApp.class, args);
	}

}
