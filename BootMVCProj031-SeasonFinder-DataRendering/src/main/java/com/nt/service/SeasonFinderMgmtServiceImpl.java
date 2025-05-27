//SeasonFinderMgmtServiceImp.java(29.03.2025)
package com.nt.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service("seasonService")
public class SeasonFinderMgmtServiceImpl implements ISeasonFinderMgmtService {

	@Override
	public String findSeason() {
		//Business Logic To Find The Curret Season Name
		//Get System Date
		LocalDate date=LocalDate.now();
		//Get Current Month Of A Year
		int month=date.getMonthValue();
		//Find The Season Name 
		if(month>=3 && month<=6)
			return "Summer Season";
		else if(month>=7 && month<=10)
			return "Rainy Season";
		else
				return "Winter Season";
		}
}
