package com.nt;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj12I18nApplication {
    
	@Bean(name="localeResolver")
	public SessionLocaleResolver createSLResolver() {
		SessionLocaleResolver resolver=new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en","US"));
		return resolver;
	}
	
	@Bean
	public LocaleChangeInterceptor createLCInterceptor() {
	     LocaleChangeInterceptor interceptor=new LocaleChangeInterceptor()	;
	     interceptor.setParamName("lang");
	     return interceptor;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj12I18nApplication.class, args);
	}

}
