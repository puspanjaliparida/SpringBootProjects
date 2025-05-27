//ActorAPIRegistrationTestRunner.java(02.05.2025)
package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorAPIPatchTestRunner implements CommandLineRunner{
	 @Autowired
	 private RestTemplate template;
	 
	@Override
	public void run(String... args) throws Exception {
		//Prepare BaseURL
		String url="http://localhost:8080/BootRestProj11-MiniProject-ActorAPI-Swagger/actor-api/update/{id}/{hikePercentage}";
		template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		
		//Use PatchForObject(-,-)method
		String result=template.patchForObject(url, null, String.class,42,10.0);
		
		//Process The Response
		System.out.println("Response Body(Result)::"+result);
		System.exit(0);
	}
}
