//B.java(21.01.2025)
package com.nt.sbeans;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

//@Component("b1")
public class B {
  private  A  a;
  
  
  public B(A  a) {
	  System.out.println("B:: 1 -Param Constructor");
	  this.a=a;
	}
  
	/*@Autowired
	public   void setA(A a) {
	  System.out.println("B.setA()");
	  this.a=a;
	}*/
  
  //ToString()
  public  String  toString() {
	  return  "a=";
  }
}
