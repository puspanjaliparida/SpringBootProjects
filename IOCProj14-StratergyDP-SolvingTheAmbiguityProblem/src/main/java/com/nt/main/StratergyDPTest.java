//StatergyDPTest.java(Client Application)(25.01.2025)
package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.nt.config.AppConfig;
import com.nt.sbeans.Flipkart;

public class StratergyDPTest {
    
	public static void main(String[] args) {
		//Create The IOC Container
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		//Get Target Spring Bean Class Object Reference
		Flipkart fpkt=ctx.getBean("fpkt",Flipkart.class);
		//Invoke The Business Method
		String resultMsg=fpkt.shopping(new String[] {"Shirt","Trouser"},
				                                                 new double[] {5000.0,6000.0});
		System.out.println(resultMsg);	 
		//Close The Container
		ctx.close();
	}
}
