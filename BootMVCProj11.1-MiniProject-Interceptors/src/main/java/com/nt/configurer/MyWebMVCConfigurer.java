//MyWebMVCConfigurer.java(10.04.2025)
package com.nt.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nt.interceptor.TimeCheckingInterceptor;

@Component
public class MyWebMVCConfigurer implements WebMvcConfigurer {
    @Autowired
	private TimeCheckingInterceptor tci;
    
    public void addInterceptors(InterceptorRegistry registry) {
    	 registry.addInterceptor(tci);
    }
}
