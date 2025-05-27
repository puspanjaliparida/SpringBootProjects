//DependencyInjectionTest.java(Dependent Spring Bean Class)(06.01.2025)
package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.cfgs.AppConfig;
import com.nt.sbeans.WishMessageGenerator;

public class DependencyInjectionTest {
      public static void main(String[] args) {
    	  //Create IOC Container
    	 AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
    	 //Get Target Spring Bean Class Object Reference
    	 WishMessageGenerator generator=ctx.getBean("wishMessageGenerator",WishMessageGenerator.class);
    	 //Invoke The Business Method
    	 String msg=generator.generateWishMessage("Omm");
    	 System.out.println(msg);
    	 //Close IOC Container
    	 ctx.close();
      }
}
