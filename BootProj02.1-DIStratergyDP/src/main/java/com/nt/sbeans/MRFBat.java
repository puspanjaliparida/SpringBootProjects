//MRFBat.java(06.02.2025)
package com.nt.sbeans;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component("mrfBat")
public final class MRFBat implements ICricketBat{

	public MRFBat() {
		System.out.println("MRFBat::0-Param Constructor");
	}
	
	@Override
	public int scoreRuns() {
		System.out.println("MRFBat.scoreRuns()");
		int score=new Random().nextInt(200);
		return score;
	}
}
