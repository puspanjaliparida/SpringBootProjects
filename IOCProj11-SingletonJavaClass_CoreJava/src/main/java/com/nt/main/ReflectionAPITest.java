//ReflectionAPITest.java(21.01.2025)
package com.nt.main;

import java.lang.reflect.Constructor;

public class ReflectionAPITest {

	public static void main(String[] args)throws Exception {
		//Load The  Class
		Class clazz=Class.forName("com.nt.ston.Printer");
		//Get All Constructors Of The  Loaded Class
		Constructor cons[]=clazz.getDeclaredConstructors();
		//Get Access To Private Constructor
		cons[0].setAccessible(true);
		//Create Objects
		Object obj1=cons[0].newInstance();
		Object obj2=cons[0].newInstance();
		//Display The Data
		System.out.println(obj1.getClass()+"   "+obj2.getClass());
		System.out.println(obj1.hashCode()+"   "+obj2.hashCode());
	}
}
