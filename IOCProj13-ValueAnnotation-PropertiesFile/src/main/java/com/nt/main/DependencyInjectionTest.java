//DependencyInjectionTest.java(Client Application)(24.02.2025)
package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.nt.config.AppConfig;
import com.nt.sbeans.PersonDetails;
import com.nt.sbeans.TestBean;

public class DependencyInjectionTest {
        public static void main(String[] args) {
        	//Create IOC Container
        	AnnotationConfigApplicationContext ctx=
        			new AnnotationConfigApplicationContext(AppConfig.class);
        	//Get Spring Bean Class Object Reference
        	PersonDetails details=ctx.getBean("pDetails",PersonDetails.class);
        	System.out.println(details);
        	System.out.println("===================");
        	Environment env=ctx.getEnvironment();
        	System.out.println("Env Object Class Name::"+env.getClass());
        	System.out.println("per.name Key Value::"+env.getProperty("per.name"));
        	System.out.println("os.name(system) Key Value::"+env.getProperty("os.name"));
        	System.out.println("==========================");
        	TestBean tb=ctx.getBean("tb",TestBean.class);
        	System.out.println("Data Is::"+tb.displayData());
        	//Close The Container
        	ctx.close();
        }
}
