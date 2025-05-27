//VotingEligibilityChecking(30.02.2025)
package com.nt.sbeans;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("vec")
public class VotingEligibilityChecking {
	@Value("${voting.name}")
	private String  name;
	@Value("${voting.age}")
	private  float  age;
	@Value("${voting.verifiedBy}")
	private  String verifiedBy;
	private   LocalDateTime  verifiedOn;
	
	static {
		System.out.println("VotingElgibilityChecking:Static Block");
	}
	
	public VotingEligibilityChecking() {
		System.out.println("VotingElgibilityChecking:: 0-Param Constructor");
	}
	
	@PostConstruct
	public void myInit() {
		System.out.println("VotingElgibilityChecking.MyInit()");
		//Initialize  Left Over Properties
		verifiedOn=LocalDateTime.now();
		//Check Whether Important Properties  Are Injected With Correct Values Or Not
		if(age<=0 || name==null)
			throw new IllegalArgumentException("Invalid Inputs For Name , Age");
		
	}
	
	
	//b.method
	public  String   checkVotingElgibility() {
		System.out.println("VotingElgibilityChecking.checkVotingElgibility()");
		if(age>=18)
			return  "Mr/Miss/Mrs."+name +"  u r  elgible for Voting verified by-"+verifiedBy+" VerifiedOn::"+verifiedOn;
		else
			return  "Mr/Miss/Mrs."+name +"  u r not elgible for Voting verified by-"+verifiedBy+" VerifiedOn::"+verifiedOn;
				
	}
	
	
	@PreDestroy
	public  void   myDestroy() {
		System.out.println("VotingElgibilityChecking.myDestroy()");
		//nullify  spring bean  properites
		name=null;
		age=0;
		verifiedBy=null;
		verifiedOn=null;
	}
	

}
