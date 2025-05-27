//DependencyInjectionTest.java(31.12.2024)
package com.nt.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.sbeans.WishMessageGenerator;

public class DependencyInjectionTest {
	
      public static void main(String[] args) {
    	  System.out.println("DependencyInjectionTest.Main() Start");
    	  
    	  //Create The IOC Container
    	  FileSystemXmlApplicationContext ctx=
    			  new FileSystemXmlApplicationContext("src/com/nt/cfgs/applicationContext.xml");
    	  
    	  //Get Target Spring Bean Class Object Reference From The IOC Container
    	  Object obj=ctx.getBean("wmg");
    	  
    	  //Type Casting
    	  WishMessageGenerator generator=(WishMessageGenerator)obj;
    	  
    	  //Invoke The Business Method
    	  String result=generator.generateWishMessage("Khushi");
    	  System.out.println(result);
    	  
    	  //Close The IOC Container
    	  ctx.close();
    	  System.out.println("DependencyInjectionTest.Main() End");
      }
}
