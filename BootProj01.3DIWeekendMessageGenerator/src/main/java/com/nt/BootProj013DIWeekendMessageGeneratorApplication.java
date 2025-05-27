//BootProj013DiWeekendMessageGeneratorApplication.java(04.02.2025)
package com.nt;

import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.WeekendMessageGenerator;

@SpringBootApplication
public class BootProj013DIWeekendMessageGeneratorApplication {

    // Bean For Getting The Current Date
    @Bean(name = "ldate")
    LocalDate createLDate() {
        return LocalDate.now();
    }

    public static void main(String[] args) {
        // Get IOC Container
        ApplicationContext ctx = SpringApplication.run(BootProj013DIWeekendMessageGeneratorApplication.class, args);

        // Get The WeekendMessageGenerator Bean
        WeekendMessageGenerator generator = ctx.getBean("wmg", WeekendMessageGenerator.class);

        // Invoke The Business Method
        String msg = generator.generateMessage();
        System.out.println(msg);

        // Close The Container
        ((ConfigurableApplicationContext) ctx).close();
    }
}
