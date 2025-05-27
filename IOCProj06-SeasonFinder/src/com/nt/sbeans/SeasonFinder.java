//SeasonFinder.java(Target Spring Bean Class)(04.01.2025)
package com.nt.sbeans;

import java.time.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("season")
public class SeasonFinder {
      @Autowired //Field Injection
      private Month m;
      
     public SeasonFinder() {
		System.out.println("SeasonFinder::0-Param Constructor");
	}

	//Business Method
 	public String generateSeason() {
 		//Get Current Season According To The Month
 		int month=m.getValue();
 		 if (month >= 3 && month <= 5) { // March, April, May
             return "Summer" ;
         } else if (month >= 6 && month <= 10) { // June, July, August, September, October
             return "Rainy" ;
         } else { // November, December, January, February
             return "Winter" ;
         }
 	}
}
