// CyclicInjectionTest.java (05.01.2025)
package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.cfgs.AppConfig;
import com.nt.sbeans.A;
import com.nt.sbeans.B;

public class CyclicInjectionTest {
    public static void main(String[] args) {
        // Create IOC Container
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get Beans From The Container
        A a = (A) ctx.getBean("a1");
        B b = (B) ctx.getBean(B.class);

        // Display The Beans
        System.out.println(a);
        System.out.println(b);

        // Close The Container
        ctx.close();
    }
}
