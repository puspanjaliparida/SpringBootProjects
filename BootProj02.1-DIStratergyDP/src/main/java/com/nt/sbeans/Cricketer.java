//Cricketer.java(Target Class)(06.02.2025)
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("cktr")
public final class Cricketer {
      @Autowired
      @Qualifier("bat")
      private ICricketBat bat;
      
      public Cricketer() {
    	  System.out.println("Cricketer::0-param constructor()");
      }
      public String batting() {
    	  System.out.println("Cricketer.batting()");
    	  //Use The Dependent
    	  int runs=bat.scoreRuns();
    	  return "Cricketer has scored "+runs+"runs";
      }
}
