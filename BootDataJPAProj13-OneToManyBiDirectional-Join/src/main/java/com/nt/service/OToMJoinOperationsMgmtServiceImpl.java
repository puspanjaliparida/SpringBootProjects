//OToMJoinOperationsMgmtServiceImpl.java(19.03.2025)
package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNumberRepository;

@Service
public class OToMJoinOperationsMgmtServiceImpl implements IOToMJoinOperationsMgmtService {
    @Autowired 
	private IPersonRepository personRepo;
    @Autowired
    private IPhoneNumberRepository phoneRepo;
    
	@Override
	public List<Object[]> showPersonAndPhoneNumbersUsingJoins() {
		return personRepo.showPersonAndPhoneNumbersUsingJoins();
	}

	@Override
	public List<Object[]> showPhoneNumbersAndPersonUsingJoins() {
		return phoneRepo.showPhoneNumbersAndPersonUsingJoins();
	}
}
