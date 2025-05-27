//Flipkart.java(Target Class)(10.01.2025)
package com.nt.comp;

import java.util.Arrays;
import java.util.Random;

public final class Flipkart {
      //HAS-A Property
	private ICourier courier;
	
	public void setCourier(ICourier courier) {
		System.out.println("Flipkart.SetCourier()");
		this.courier=courier;
	}
	
	//Business Method
	public String shopping(String items[],double prices[]) {
		//Calculate Bill Amount
		double billAmount=0.0;
		for(double p:prices) {
			billAmount=billAmount+p;
		}
		//Generate The Order Id(Random Number As The Order)
		int oid=new Random().nextInt(1000);
		//Deliver The Products Using Courier
		String msg=courier.deliver(oid);
		
		return Arrays.toString(items)+"Items With BillAmount::"+billAmount+"----------"+msg;
	}
}
