//BootMsProj12BillingMsProviderMsApp.java(27.05.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class BootMsProj12BillingMsProviderMsApp {

	public static void main(String[] args) {
		log.debug("BillMs main() start");
		SpringApplication.run(BootMsProj12BillingMsProviderMsApp.class, args);
		log.debug("BillMs main() end");
	}

}
