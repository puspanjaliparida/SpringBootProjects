//ClassMetaDataTest.java(21.01.2025)
package com.nt.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class ClassMetaDataTest {

	public static void main(String[] args)throws Exception {
		Class c1=Class.forName("java.util.Date");
		 
		LocalDate  ld=LocalDate.now();
		Class  c2=ld.getClass();
		
		Class c3=LocalTime.class;
		
		System.out.println(" Class Name ::"+c1.getName());
		System.out.println(" Super Class Name::"+c1.getSuperclass());
		System.out.println(" Methods Info ::"+Arrays.toString(c1.getDeclaredMethods()));
		System.out.println(" Constructors Info ::"+Arrays.toString(c1.getConstructors()));
		System.out.println(" Implemented Interfaces Info ::"+Arrays.toString(c1.getInterfaces()));
		System.out.println("-------------------");
		
		System.out.println(" Class Name ::"+c2.getName());
		System.out.println(" Super Class Name::"+c2.getSuperclass());
		System.out.println(" Methods Info ::"+Arrays.toString(c2.getDeclaredMethods()));
		System.out.println(" Constructors Info ::"+Arrays.toString(c2.getConstructors()));
		System.out.println(" Implemented Interfaces Info ::"+Arrays.toString(c2.getInterfaces()));
		System.out.println("-------------------");
		
		System.out.println(" Class Name ::"+c3.getName());
		System.out.println(" Super Class Name::"+c3.getSuperclass());
		System.out.println(" Methods Info ::"+Arrays.toString(c3.getDeclaredMethods()));
		System.out.println(" Constructors Info ::"+Arrays.toString(c3.getConstructors()));
		System.out.println(" Implemented Interfaces Info ::"+Arrays.toString(c3.getInterfaces()));
	}

}
