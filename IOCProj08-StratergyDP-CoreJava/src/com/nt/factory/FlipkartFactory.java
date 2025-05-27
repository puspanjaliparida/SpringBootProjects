//FlipkartFactory.java(Factory Pattern Class)(10.01.2025)
package com.nt.factory;

import com.nt.comp.BlueDart;
import com.nt.comp.DTDC;
import com.nt.comp.Flipkart;
import com.nt.comp.ICourier;

public class FlipkartFactory {
      //Static Factory Method Having Factory Pattern Logic
	public static Flipkart getInstance(String courierType) {
		//Create Dependent Class Object
		ICourier courier=null;
		if(courierType.equalsIgnoreCase("dtdc"))
			courier=new DTDC();
		else if(courierType.equalsIgnoreCase("blueDart"))
			courier=new BlueDart();
		else
			throw new IllegalArgumentException("Invalid Courier Type");
		//Create Target Class Object
		Flipkart fpkt=new Flipkart();
		//Assign Dependent Class Object To Target Class Object
		fpkt.setCourier(courier);
		return fpkt;
	}
}
