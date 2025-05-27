//OneToManyJoinTestRunner.java(19.03.2025)
package com.nt.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.service.IOToMJoinOperationsMgmtService;

@Component
public class OneToManyJoinTestRunner implements CommandLineRunner {
	@Autowired
    private IOToMJoinOperationsMgmtService otomService;
    
	@Override
	public void run(String... args) throws Exception {
          /*try {
        	  List<Object[]> list=otomService.showPersonAndPhoneNumbersUsingJoins();
        	  list.forEach(row->{
        		  System.out.println(Arrays.toString(row));
        	  });
          }
          catch(Exception e) {
        	  e.printStackTrace();
          }*/
		
		try {
      	  List<Object[]> list=otomService.showPhoneNumbersAndPersonUsingJoins();
      	  list.forEach(row->{
      		  System.out.println(Arrays.toString(row));
      	  });
        }
        catch(Exception e) {
      	  e.printStackTrace();
        }
	}
}
