//StatergyPatternTest.java(Client Application)(10.01.2025)
package com.nt.test;

import com.nt.comp.Flipkart;
import com.nt.factory.FlipkartFactory;

public class StratergyPatternTest {
    
	public static void main(String[] args) {
		//Use Factory Pattern To Target Class Object
		Flipkart fpkt=FlipkartFactory.getInstance("dtdc");
		//Invoke The Business Method
		String resultMsg=fpkt.shopping(new String[] {"Shirt","Trouser"},
				                                                 new double[] {5000.0,6000.0});
		System.out.println(resultMsg);	                                               
	}
}
