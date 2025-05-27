//IBankAccountMgmtService.java(11.03.2025)
package com.nt.service;

import com.nt.entity.BankAccount;

public interface IBankAccountMgmtService {
     public String createAccount(BankAccount account);
     public String withdrawMoney(long accno,double amount);
     public String depositMoney(long acno,double amount);
     public BankAccount findBankAccountByAccno(long acno);
}
