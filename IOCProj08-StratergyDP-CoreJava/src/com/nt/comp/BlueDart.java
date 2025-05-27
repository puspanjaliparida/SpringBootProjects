//BlueDart.java(Dependent Class2)(10.01.2025)
package com.nt.comp;

public class BlueDart  implements ICourier{
       
	@Override
	public String deliver(int oid) {
		return oid+" Order Items Are Kept For Delivery By BlueDart";
	}
}
