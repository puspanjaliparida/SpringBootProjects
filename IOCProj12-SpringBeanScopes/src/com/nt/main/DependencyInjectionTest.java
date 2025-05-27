//DependencyInjectionTest.java(Dependent Spring Bean Class)(21.01.2025)
package com.nt.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.WishMessageGenerator;

public class DependencyInjectionTest {

	public static void main(String[] args) {
		//Create  IOC Container
		AnnotationConfigApplicationContext  ctx=
				   new AnnotationConfigApplicationContext(AppConfig.class);
		//Get Target Spring Bean Class Object Reference
		WishMessageGenerator  generator=ctx.getBean("WishMessageGenerator",WishMessageGenerator.class);
	//Invoke The Business Method
		String msg=generator.generateWishMessage("Raja");
		
		System.out.println(msg);
		System.out.println("----------------------");
		LocalTime  time=ctx.getBean("CreateLTime",LocalTime.class);
		LocalDate  date=ctx.getBean("CreateLDate",LocalDate.class);
		System.out.println(time+"    "+date);
		
		System.out.println("----------------------");
		System.out.println("All Spring  Bean Ids ::"+Arrays.toString(ctx.getBeanDefinitionNames()));
		System.out.println("All Spring Beans Count::"+ctx.getBeanDefinitionCount());
		
		//Close  IOC Container
		ctx.close();
	}
}
