//VersoningAndTimestampingRunner.java(11.03.2025)
package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.BankAccount;
import com.nt.service.IBankAccountMgmtService;

@Component
public class VersoningAndTimestampingRunner implements CommandLineRunner{
	@Autowired
	private IBankAccountMgmtService bankService;
	
	@Override
	public void run(String... args) throws Exception {
		//Save Object(Create Bank Account)
		/*try {
			BankAccount account=new BankAccount("Himesh",10001.0,"ICICI","Savings");
		    String msg=bankService.createAccount(account);
		    System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			String msg=bankService.withdrawMoney(100000000, 4000.0);
			System.out.println(msg);
			BankAccount account=bankService.findBankAccountByAccno(100000000);
			System.out.println("Account Balance Is Modified For"+account.getUpdateCount()+"Times And Opened On"+account.getOpenedOn()+"Lastly Updated  On"+account.getLastUpdatedOn());
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			String msg=bankService.depositMoney(100000000, 4000.0);
			System.out.println(msg);
			BankAccount account=bankService.findBankAccountByAccno(100000001);
			System.out.println("Account Balance Is Modified For"+account.getUpdateCount()+"Times And Opened On"+account.getOpenedOn()+"Lastly Updated  On"+account.getLastUpdatedOn());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
