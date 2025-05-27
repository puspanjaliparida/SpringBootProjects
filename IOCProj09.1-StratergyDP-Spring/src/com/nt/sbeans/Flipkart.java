//Flipkart.java(Target Class)(10.01.2025)
package com.nt.sbeans;

import java.util.Arrays;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fpkt")
public final class Flipkart {
      //HAS-A Property
	@Autowired
	@Qualifier("bDart")
	private ICourier courier;
	
	public Flipkart() {
		System.out.println("Flipkart::0-Param Constructor");
	}
	
	//Business Method
	public String shopping(String items[],double prices[]) {
		System.out.println("Flipkart.shopping()");
		//Calculate Bill Amount
		double billAmt=0.0;
		for(double p:prices) {
			billAmt=billAmt+p;
		}
		//Generate The Order Id(Random Number As The Order)
		int oid=new Random().nextInt(10000);
		//Deliver The Order Using Courier
		String msg=courier.deliver(oid);
		
		return Arrays.toString(items)+"Are Shopped Having Bill Amount::"+billAmt+"----------"+msg;
	}
}
