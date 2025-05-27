//CyclicDITest.java(21.01.2025)
package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.A;

public class CyclicDITest {

	public static void main(String[] args) {
		//Create  IOC Container
		AnnotationConfigApplicationContext  ctx=
				  new AnnotationConfigApplicationContext(AppConfig.class);
		//Get  Spring Bean Class Object  Reference
		A  a=ctx.getBean("a1",A.class);
		System.out.println(a);
		
		//Close Container
		ctx.close();
	}

}
