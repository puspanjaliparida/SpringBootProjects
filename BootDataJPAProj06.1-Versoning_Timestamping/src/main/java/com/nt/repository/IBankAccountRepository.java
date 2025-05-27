//IBankAccountRepository.java(11.03.2025)
package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.BankAccount;

public interface IBankAccountRepository extends CrudRepository<BankAccount, Long> {

}
