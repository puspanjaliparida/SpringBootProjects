//Application.java(28.05.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class Application {

	public static void main(String[] args) {
		log.debug("Eureka server(start)");
		SpringApplication.run(Application.class, args);
		log.debug("Eureka server(end)");
	}

}
