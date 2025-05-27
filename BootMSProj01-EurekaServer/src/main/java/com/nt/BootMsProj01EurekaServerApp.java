//BootMsProj01EurekaServerApp(13.05.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootMsProj01EurekaServerApp {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj01EurekaServerApp.class, args);
	}

}
