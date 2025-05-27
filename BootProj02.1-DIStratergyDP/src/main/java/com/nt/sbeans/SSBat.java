//SSBat.java(06.02.2025)
package com.nt.sbeans;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component("ssBat")
public final class SSBat implements ICricketBat{
	
     public SSBat() {
    	 System.out.println("SSBat::0-Param Constructor");
     }
     
     @Override
     public int scoreRuns() {
    	  System.out.println("SSBat.scoreRuns()");
    	  int score=new Random().nextInt(200);
    	  return score;
     }
}
