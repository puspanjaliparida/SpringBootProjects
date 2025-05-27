//MySQLPLSQLProcedureRunner.java(14.03.2025)
package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorMgmtService;

@Component
public class MySQLPLSQLProcedureRunner implements CommandLineRunner {

	@Autowired
	private IDoctorMgmtService docService;
	
	@Override
	public void run(String... args) throws Exception {
          //Invoke The Business Method Of Service
		docService.showDoctorsByIncomeRange(10000.0,2000000.0).forEach(System.out::println);
	}
}
