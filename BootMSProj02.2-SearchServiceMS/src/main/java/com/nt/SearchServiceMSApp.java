//SearchServiceMSApp(14.05.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SearchServiceMSApp {

	public static void main(String[] args) {
		SpringApplication.run(SearchServiceMSApp.class, args);
	}

}
