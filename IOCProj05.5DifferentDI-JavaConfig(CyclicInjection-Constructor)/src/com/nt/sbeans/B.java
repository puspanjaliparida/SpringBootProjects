//B.java(05.01.2025)
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("b1")
public class B {
         private A a;
         
         public B(A a) {
        	 System.out.println("B::1-Param Constructor");
        	 this.a=a;
         }
         
         //ToString()
         public String toString() {
        	 return "a=";
         }
}
