//BootMsProj08ShoppingMsConsumer.java(20.05.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BootMsProj08ShoppingMsConsumer {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj08ShoppingMsConsumer.class, args);
	}

}
