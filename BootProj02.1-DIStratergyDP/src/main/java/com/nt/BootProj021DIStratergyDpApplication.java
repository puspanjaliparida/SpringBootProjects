//BootProj021DiStratergyDpApplication(06.02.2025)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbeans.Cricketer;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj021DIStratergyDpApplication {

	public static void main(String[] args) {
		//Get Access To IOC Container
	   ApplicationContext  ctx=SpringApplication.run(BootProj021DIStratergyDpApplication.class, args);
	   //Get Target Spring Bean Class Object Reference
	   Cricketer cktr=ctx.getBean("cktr",Cricketer.class);
	   //Invoke The Business Method
	   String msg=cktr.batting();
	   System.out.println(msg);
	   //Close The Container
	   ((ConfigurableApplicationContext) ctx).close();
	}

}
