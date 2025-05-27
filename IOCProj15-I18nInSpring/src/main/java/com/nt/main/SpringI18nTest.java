//SpringI18nTest.java
package com.nt.main;

import java.util.Locale;
import java.util.Scanner;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;

public class SpringI18nTest {
     
	public static void main(String[] args) {
		try (//Read Language Code And Country From The End User
		Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Language Code :: ");
			String lang=sc.next();
			
			System.out.println("Enter Country Code ::");
			String country=sc.next();
			
			//Prepare Locale Object Having Language Code And Country Code
			Locale locale=new Locale(lang,country);
			
			//Create IOC Container
			AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
			//Call ctx.getMessage(-) Method To Get Locale Specific Messages
			String msg1=ctx.getMessage("welcome.msg", new String[] {"Khushi"}, locale);
			String msg2=ctx.getMessage("goodbye.msg", new String[] {}, locale);
			String msg3=ctx.getMessage("missing.msg", new String[] {}, locale);
			String msg4=ctx.getMessage("disconnect.msg", new String[] {}, locale);
			System.out.println(msg1+"-- "+msg2+"-- "+msg3+" --"+msg4);
			
			//Close The Container
			ctx.close();
		} catch (NoSuchMessageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//Main
}//Class
