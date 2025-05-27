//BootProj012DIWishMessageGeneratorApplication.java(04.02.2025)
package com.nt;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.nt.sbeans.WishMessageGenerator;

@SpringBootApplication
@ComponentScan(basePackages = "com.nt.sbeans") 
public class BootProj012DIWishMessageGeneratorApplication {

	@Bean(name="ltime")
     LocalTime createLTime() {
   	 return LocalTime.now();
    }
    
    @Bean(name="ldate")
    LocalDate createLDate() {
   	 return LocalDate.now();
    }
	
	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj012DIWishMessageGeneratorApplication.class, args);
		//get Target spring bean class object
		WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class); 
		//invoke the b.method
		String msg=generator.generateWishMessage("Omm");
   	    System.out.println(msg); 
   	    
   	    //close the container
   	    ((ConfigurableApplicationContext) ctx).close();
	}
}
