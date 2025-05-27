//DependencyInjectionTest.java(04.01.2025)
package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.cfgs.AppConfig;
import com.nt.sbeans.SeasonFinder;

public class DependencyInjectionTest {
	
      public static void main(String[] args) {
    	  //Create IOC Container
    	 AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
    	 //Get Target Spring Bean Class Object Reference
    	 SeasonFinder generator=(SeasonFinder)ctx.getBean("season");
    	 //Invoke The Business Method
    	 String season=generator.generateSeason();
    	 System.out.println("The Current Season Is:"+season);
    	 //Close IOC Container
    	 ctx.close();
      }
}
