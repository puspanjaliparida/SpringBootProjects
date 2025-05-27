package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IPurchaseMgmtService;

@Component
public class SpringBootMailTestRunner implements CommandLineRunner {
    @Autowired
	private IPurchaseMgmtService purchaseService;
	
    @Override
	public void run(String... args) throws Exception {
    	try {
    		String resultMsg=purchaseService.shopping(new String[] {"shirt", "trouser", "hat"},
    				                                                                                new Double[] {4000.0,5000.0,3000.0},
    				                                                                                new String[] {"smnanda03@gmail.com"});
    		System.out.println(resultMsg);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
	}

}
