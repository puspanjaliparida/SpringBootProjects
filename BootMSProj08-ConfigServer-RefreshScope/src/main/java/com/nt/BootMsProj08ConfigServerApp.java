//BootMsProj08ConfigServerApp.java(20.05.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BootMsProj08ConfigServerApp {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj08ConfigServerApp.class, args);
	}

}
