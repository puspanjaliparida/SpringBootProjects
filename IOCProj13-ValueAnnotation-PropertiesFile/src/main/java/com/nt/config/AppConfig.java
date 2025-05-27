//AppConfig.java(24.02.2025)
package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"com/nt/commons/Info.properties","com/nt/commons/Info1.properties"})
@ComponentScan(basePackages="com.nt")
public class AppConfig {

}
