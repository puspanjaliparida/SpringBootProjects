//ActorAPIRegistrationTestRunner.java(02.05.2025)
package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorAPIUpdationTestRunner implements CommandLineRunner{
	 @Autowired
	 private RestTemplate template;
	 
	@Override
	public void run(String... args) throws Exception {
		//Prepare BaseURL
		String url="http://localhost:8080/BootRestProj11-MiniProject-ActorAPI-Swagger/actor-api/update";
		
		//Prepare json body
		String json_body="{\"aid\":42,\"aname\":\"Vijay\",\"category\":\"hero\",\"fee\":63832.0,\"industry\":\"bollywood\",\"dob\":\"2025-03-21T11:30\"}";
		
		//Http headers
		HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//Prepare HttpEntity object having headers,body
	    HttpEntity<String> entity=new HttpEntity<String>(json_body,headers);
	    
	    //Use put(-,-) method
	    template.put(url , entity);
	    System.out.println("Actor Updated");
		System.exit(0);
	}
}
