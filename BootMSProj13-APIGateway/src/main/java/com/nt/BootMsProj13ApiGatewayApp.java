//BootMsProj13ApiGatewayApp.java(28.05.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj13ApiGatewayApp {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj13ApiGatewayApp.class, args);
	}

}
