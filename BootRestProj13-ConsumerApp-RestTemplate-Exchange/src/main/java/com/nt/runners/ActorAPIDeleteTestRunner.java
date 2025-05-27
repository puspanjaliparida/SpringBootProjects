//ActorAPIRegistrationTestRunner.java(06.05.2025)
package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorAPIDeleteTestRunner implements CommandLineRunner{
	 @Autowired
	 private RestTemplate template;
	 
	@Override
	public void run(String... args) throws Exception {
		//Prepare BaseURL
		String url="http://localhost:8080/BootRestProj11-MiniProject-ActorAPI-Swagger/actor-api/remove/{id}";
		
		//Use delete()
		ResponseEntity<String> response=template.exchange(url,
				                               HttpMethod.DELETE,
				                               null,
				                               String.class,
				                               42);
		
		//Process the response
		System.out.println("Actor Deleted");
		
		System.exit(0);
	}
}
