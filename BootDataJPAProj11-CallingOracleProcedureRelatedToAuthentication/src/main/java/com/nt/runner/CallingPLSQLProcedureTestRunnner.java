//CallingPLSQLProcedureTestRunnner.java(15.03.2025)
package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IAuthenticationMgmtService;

@Component
public class CallingPLSQLProcedureTestRunnner implements CommandLineRunner {
     @Autowired
     private IAuthenticationMgmtService authService;
     
	@Override
	public void run(String... args) throws Exception {
		try {
			//Invoke The Service
			String msg=authService.login("KHUSHI","HYDd");
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
