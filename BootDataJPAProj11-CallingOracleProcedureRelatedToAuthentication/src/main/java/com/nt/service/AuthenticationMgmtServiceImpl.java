//AuthenticationMgmtServiceImpl.java(15.03.2025)
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class AuthenticationMgmtServiceImpl implements IAuthenticationMgmtService {
    @Autowired
	private EntityManager manager;
	@Override
	public String login(String username, String password) {
		//Create Stored procedure Query Object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_AUTHENTICATION_CREDENTIALS");
		//Register The Parameter Of PL/SQL Proceduer
		query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(3,String.class,ParameterMode.OUT);
		
		//Set  The Values To IN Parameter Query
		query.setParameter(1, username);
		query.setParameter(2, password);
		
		//Exceute The Query
		String  result=(String) query.getOutputParameterValue(3);
		return result;
	}

}
