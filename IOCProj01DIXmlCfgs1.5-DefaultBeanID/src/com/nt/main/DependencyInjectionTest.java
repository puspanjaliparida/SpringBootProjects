//DependencyInjectionTest.java(06.01.2025)
package com.nt.main;

import java.time.LocalTime;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DependencyInjectionTest {
	
      public static void main(String[] args) {
    	  System.out.println("DependencyInjectionTest.Main() Start");
    	  
    	  //Create The IOC Container
    	  FileSystemXmlApplicationContext ctx=
    			  new FileSystemXmlApplicationContext("src/com/nt/cfgs/applicationContext.xml");
    	 
    	  LocalTime time1=ctx.getBean("java.time.LocalTime",LocalTime.class);
    	  LocalTime time2=ctx.getBean("java.time.LocalTime#0",LocalTime.class);
    	  LocalTime time3=ctx.getBean("java.time.LocalTime#1",LocalTime.class);

    	  System.out.println(time1+" "+time2+" "+time3);
    	  
    	  //Close The IOC Container
    	  ctx.close();
    	  System.out.println("DependencyInjectionTest.Main() End");
      }
}
