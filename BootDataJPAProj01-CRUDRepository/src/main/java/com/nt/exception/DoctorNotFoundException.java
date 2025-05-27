//DoctorNotFoundException.java(03.03.2024)
package com.nt.exception;

public class DoctorNotFoundException extends RuntimeException{
    //No Param Constructor  
	public DoctorNotFoundException() {
      }
	
      //1 Param Constructor
      public DoctorNotFoundException(String msg) {
    	  super(msg);
      }
}
