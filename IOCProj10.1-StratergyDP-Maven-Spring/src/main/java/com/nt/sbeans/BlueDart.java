//BlueDart.java(Dependent Class2)(20.01.2025)
package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("bDart")
@Lazy(true)
public final class BlueDart  implements ICourier{
    
	public BlueDart() {
		System.out.println("BlueDart::0-Param Constructor");
	}
	@Override
	public String deliver(int oid) {
		return "BlueDart Courier Is Ready To Delivery"+oid+"Order Number Products";
	}
}
