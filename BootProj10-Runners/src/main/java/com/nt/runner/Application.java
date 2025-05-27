//Application.java(21.02.2025)
package com.nt.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Application implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ApplicationRunners.Run()");
		System.out.println("Non Option Args Values::"+args.getNonOptionArgs());
		
		System.out.println("Option Arg Names And Values::");
		for(String name:args.getOptionNames()) {
			System.out.println(name+"---->"+args.getOptionValues(name));
		}
	}

}
