//AppConfig.java(05.01.2025)
package com.nt.cfgs;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.nt.sbeans")
public class AppConfig {
         public AppConfig() {
        	 System.out.println("AppConfig:0-Param Constructor");
         }
         
         @Bean(name="ltime")
         public LocalTime createLTime() {
        	 System.out.println("AppConfig.CreateLTime()");
        	 return LocalTime.now();
         }
         
         @Bean(name="ldate")
         public LocalDate createLDate() {
        	 System.out.println("AppConfig.CreateLDate()");
        	 return LocalDate.now();
         }
}
