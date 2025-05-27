//ActorAPIRegistrationTestRunner.java(06.05.2025)
package com.nt.runners;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ActorAPIRegistrationTestRunner implements CommandLineRunner{
	 @Autowired
	 private RestTemplate template;
	 
	@Override
	public void run(String... args) throws Exception {
		//Prepare BaseURL
		String url="http://localhost:8080/BootRestProj11-MiniProject-ActorAPI-Swagger/actor-api/register";
		
		//Prepare JSON body
		String json_body="{\"aname\":\"Prem\",\"category\":\"hero\",\"fee\":89932.0,\"industry\":\"bollywood\",\"dob\":\"2025-03-21T10:30\"}";
		//Http headers
		HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//Prepare HttpEntity Object having headers,body
		HttpEntity<String> entity=new HttpEntity<String>(json_body,headers);
		//Use PostForEntity(-,-)method
		ResponseEntity<String> response=template.exchange(url,
				                                                                                                    HttpMethod.POST,
				                                                                                                    entity,
				                                                                                                    String.class);
		//Process The Response
		System.out.println("Response body(result):: "+response.getBody());
		System.out.println("Response headers:: "+response.getHeaders());
		System.out.println("Response status code:: "+response.getStatusCode());
	}
}
