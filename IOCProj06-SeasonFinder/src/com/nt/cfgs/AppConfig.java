//AppConfig.java(04.01.2025)
package com.nt.cfgs;

import java.time.LocalDate;
import java.time.Month;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.nt.sbeans")
public class AppConfig {
         public AppConfig() {
        	 System.out.println("AppConfig:0-Param Constructor");
         }
   
         @Bean(name="month")
         public Month createMonth() {
        	 System.out.println("AppConfig.CreateMonth()");
        	 return LocalDate.now().getMonth();
         }
}
