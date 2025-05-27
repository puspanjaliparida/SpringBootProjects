//ActorAPIRegistrationTestRunner.java(06.05.2025)
package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorAPIFindByIdTestRunner implements CommandLineRunner{
	 @Autowired
	 private RestTemplate template;
	 
	@Override
	public void run(String... args) throws Exception {
		//Prepare BaseURL
		String url="http://localhost:8080/BootRestProj11-MiniProject-ActorAPI-Swagger/actor-api/find/{id}";
		
		//Use PostForEntity(-,-)method
		ResponseEntity<String> response=template.exchange(url,
				                                                                                                    HttpMethod.GET,
				                                                                                                    null,
				                                                                                                    String.class,
				                                                                                                    42);
		//Process The Response
		System.out.println("Response body(result):: "+response.getBody());
		System.out.println("Response headers:: "+response.getHeaders());
		System.out.println("Response status code:: "+response.getStatusCode().value());
		
		System.exit(0);
	}
}
