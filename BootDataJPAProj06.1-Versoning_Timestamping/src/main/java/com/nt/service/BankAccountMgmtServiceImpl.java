//BankAccountMgmtServiceImpl.java(11.03.2025)
package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.BankAccount;
import com.nt.repository.IBankAccountRepository;

@Service
public class BankAccountMgmtServiceImpl implements IBankAccountMgmtService {
    @Autowired
	private IBankAccountRepository bankRepo;
    
	@Override
	public String createAccount(BankAccount account) {
		long acno=bankRepo.save(account).getAcno();
		return "Bank Account Is Opened With Account Number::"+acno;
	}

	@Override
	public String withdrawMoney(long accno, double amount) {
		//Load The Account
		Optional<BankAccount> opt=bankRepo.findById(accno);
		if(opt.isPresent()) {
			//Get The Object
			BankAccount account=opt.get();
			//Update The Object 
			account.setBalance(account.getBalance()-amount);
			bankRepo.save(account);
			return amount+"Money Is WithDrawn From The BankAccount";
		}else {
			return accno+"Bank Account Is Not Found";
		}
	}

	@Override
	public String depositMoney(long acno, double amount) {
		//Load The Account
				Optional<BankAccount> opt=bankRepo.findById(acno);
				if(opt.isPresent()) {
					//Get The Object
					BankAccount account=opt.get();
					//Update The Object 
					account.setBalance(account.getBalance()+amount);
					bankRepo.save(account);
					return amount+"Money Is Deposited To The BankAccount";
				}else {
					return acno+"Bank Account Is Not Found";
				}
	}

	@Override
	public BankAccount findBankAccountByAccno(long acno) {
		//Load Object
		BankAccount account=bankRepo.findById(acno).orElseThrow(()->new IllegalArgumentException("Invalid BankAccount Number"));
		return account;
	}
}
