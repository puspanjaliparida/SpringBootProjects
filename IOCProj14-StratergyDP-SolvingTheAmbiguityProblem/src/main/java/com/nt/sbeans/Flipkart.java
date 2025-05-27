//Flipkart.java(Target Class)(25.01.2025)
package com.nt.sbeans;

import java.util.Arrays;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("fpkt")
@PropertySource("com/nt/commons/myfile.properties")
public final class Flipkart {
      //HAS-A Property
	@Autowired
	@Qualifier("shipment")
	//@Qualifier("${courier.id}") //Invalid --Because We Can Not Place The Place Holder ${<key>} In @Qualifier Annotation --Allowed In @Value Annotation
	//@Qualifier(@Value("${courier.id}")) //Invalid --Because We Can Not Place @Value Annotation Inside The @Qualifier Annotation 
	/*@Value("${courier.id}")
	private String beanid;
	@Qualifier("beanid" ) */
	//Invalid Because We Can Not Pass Variable Name To @Qualifier As The Bean Id
	private ICourier courier;
	
	public Flipkart() {
		System.out.println("Flipkart::0-Param Constructor");
	}
	
	//Business Method
	public String shopping(String items[],double prices[]) {
		System.out.println("Flipkart.Shopping()");
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
