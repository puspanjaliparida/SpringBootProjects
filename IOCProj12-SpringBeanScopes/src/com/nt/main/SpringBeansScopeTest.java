//SpringbeanScopeTest.java(21.01.2025)
package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.WishMessageGenerator;

public class SpringBeansScopeTest {

	public static void main(String[] args) {
		//Create  IOC Container
		AnnotationConfigApplicationContext  ctx=
				   new AnnotationConfigApplicationContext(AppConfig.class);
		
				// Get Spring Bean Class Object  Reference
				WishMessageGenerator  generator1=ctx.getBean("wmg",WishMessageGenerator.class);
				WishMessageGenerator  generator2=ctx.getBean("wmg",WishMessageGenerator.class);
				System.out.println(generator1.hashCode()+"   "+generator2.hashCode());
				System.out.println("generator==generator2?"+(generator1==generator2));
			
		/*	System.out.println("-----------------------------");
			LocalDate  ld1=ctx.getBean("ld",LocalDate.class);
			LocalDate  ld2=ctx.getBean("ld",LocalDate.class);
			System.out.println(ld1.hashCode()+"   "+ld2.hashCode());
			
			System.out.println("-----------------------------");
			Date  d1=ctx.getBean("dt1",Date.class);
			Date  d2=ctx.getBean("dt1",Date.class);
			System.out.println(d1.hashCode()+"   "+d2.hashCode());
			
			System.out.println("-----------------------------");
			Date  d3=ctx.getBean("dt2",Date.class);
			Date  d4=ctx.getBean("dt2",Date.class);
			System.out.println(d3.hashCode()+"   "+d4.hashCode());
		*/	
		
		/*	Printer  prn1=ctx.getBean("prn1",Printer.class);
			Printer  prn2=ctx.getBean("prn1",Printer.class);
			System.out.println(prn1.hashCode()+"    "+prn2.hashCode());
		*/
		//Close  IOC Container
		ctx.close();
	}
}
