//ActorAPIFindAllTestRunner.java(06.05.2025)
package com.nt.runners;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nt.vo.ActorVO;

//@Component
public class ActorAPIFindAllTestRunner implements CommandLineRunner{
	 @Autowired
	 private RestTemplate template;
	 
	@Override
	public void run(String... args) throws Exception {
		String url="http://localhost:8080/BootRestProj11-MiniProject-ActorAPI-Swagger/actor-api/all";
		//Use getForEntity(-,-) method
		ResponseEntity<String> response=template.exchange(url,
				                                                                                                    HttpMethod.GET,
				                                                                                                    null,
				                                                                                                    String.class);
		//Process The Response
		System.out.println("Response body(result):: "+response.getBody());
		System.out.println("Response headers:: "+response.getHeaders());
		System.out.println("Response status code:: "+response.getStatusCode());
		
		//Convert Json text to Model class object Using Jackson API
		ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // Enables LocalDateTime support
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Optional: pretty ISO-8601 format

        // Deserialize JSON array into List<ActorVO>
        List<ActorVO> list = mapper.readValue(response.getBody(), new TypeReference<List<ActorVO>>() {});
        
        System.out.println("JSON Array to List<ActorVO> Object::");
        list.forEach(System.out::println);
	}
}
