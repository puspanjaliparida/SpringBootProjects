//BootMsProj07ShoppingMsConsumer.java(19.05.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BootMsProj07ShoppingMsConsumer {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj07ShoppingMsConsumer.class, args);
	}

}
