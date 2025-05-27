//SpringBeanLifeCycleTest.java(30.01.2025)
package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.nt.config.AppConfig;
import com.nt.sbeans.VotingEligibilityChecking;

public class SpringBeanLifeCycleTest {

	public static void main(String[] args) {
		//Create  IOC Container
		AnnotationConfigApplicationContext  ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		//Get Spring Bean Class Object Reference
		VotingEligibilityChecking  vec=ctx.getBean("vec",VotingEligibilityChecking.class);
		// Invoke The Business Method
		String resultMsg=vec.checkVotingElgibility();
		System.out.println(resultMsg);
       //Close  IOC Container
		ctx.close();
	}
}
