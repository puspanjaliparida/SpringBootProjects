//DTDC.java(Dependent Class1)(10.01.2025)
package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("dtdc")
@Lazy(true)
//@Component("courier")
//@Primary
public final class DTDC implements ICourier{
 
	public DTDC() {
		System.out.println("DTDC::0-Param Constructor");
	}
	@Override
	public String deliver(int oid) {
		return "DTDC Courier Is Ready To Delivery"+oid+"Order Number Products";
	}
}
