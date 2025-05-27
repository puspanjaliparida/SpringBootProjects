//AppConfig.java(Configuration Class)(25.01.2025)
package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages="com.nt")
//@PropertySource("com/nt/commons/myfile.properties")
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class AppConfig {
       
	public AppConfig() {
		System.out.println("AppConfig::0-Param Constructor");
	}
}
