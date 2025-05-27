//SeasonFinder.java(Target Class)(04.02.2025)
package com.nt.sbeans;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {
     //Bean Property
	@Autowired
	private LocalDate ldt;
	
	//Business Method
	public String findSeason() {
		//Get Current Month
		int month=ldt.getMonthValue();
		//Show Season Name
		if(month>=3 && month<=6)
			return "Summer Season";
		else if(month>=7 && month<=10)
			return "Rainy Season";
		else
			return "Winter Season";
	}
}
