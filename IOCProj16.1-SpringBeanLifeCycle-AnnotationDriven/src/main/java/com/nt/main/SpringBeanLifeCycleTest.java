//SpringBeanLifeCycleTest.java(30.01.2025)
package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.nt.config.AppConfig;
import com.nt.sbeans.MarriageEligibilityChecking;

public class SpringBeanLifeCycleTest {

    public static void main(String[] args) {
        // Create IOC Container
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        // Get Spring Bean Class Object Reference
        MarriageEligibilityChecking mec = ctx.getBean("mec", MarriageEligibilityChecking.class);
        
        // Invoke Business Method
        String resultMsg = mec.checkMarriageEligibility();
        System.out.println(resultMsg);
        
        // Close IOC Container
        ctx.close();
    }
}
