//DependencyInjectionTest.java(01.01.2025)
package com.nt.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.WishMessageGenerator;

public class DependencyInjectionTest {
	
      public static void main(String[] args) {
    	  
    	  //Create IOC Container
    	  ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
    	  
    	  //Get Target Spirng Bean Class Object Reference From The IOC Container
    	  Object obj=ctx.getBean("wmg");
    	  
    	  //Type Casting
    	  WishMessageGenerator generator=(WishMessageGenerator)obj;
    	  System.out.println("Gathering Target Spring Bean Class Object Reference");
    	  
    	  //Invoke The Business Method
    	  String result=generator.generateWishMessage("Khushi");
    	  System.out.println(result);
    	  
    	  //Close The IOC Container
    	  ctx.close();
    	  System.out.println("DependencyInjectionTest.Main() End");
      }
}
