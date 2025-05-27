//BootProj011DependencyInjectionApplication(Main class)(04.02.2025)
package com.nt;

import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class BootProj011DependencyInjectionApplication {

    @Bean(name = "ldt")
    LocalDate createDate() {
    	  return LocalDate.now();
      }
      
	public static void main(String[] args) {
		//Get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj011DependencyInjectionApplication.class, args);
		//Get Target Spring Bean Class Object
		SeasonFinder finder=ctx.getBean("sf",SeasonFinder.class);
		//Invoke The Business Method
		String seasonName=finder.findSeason();
		System.out.println("Season Name::"+seasonName);
		
	//Close The IOC Container
		((ConfigurableApplicationContext) ctx).close();
	}

}
