//A.java(05.01.2025)
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("a1")
public class A {
       private B b;
       
      public A(B b) {
    	  System.out.println("A::1-Param Constructor");
    	  this.b=b;
      }
       //ToString()
       @Override
       public String toString() {
    	   return "b=";
       }
}
