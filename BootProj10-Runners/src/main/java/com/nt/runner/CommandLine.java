//CommandLineRunner.java(21.02.2025)
package com.nt.runner;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CommandLine implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunners.Run()");
		System.out.println("Runners To Test..."+Arrays.toString(args));
	}
       
}
