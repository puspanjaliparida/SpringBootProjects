//B.Java(05.01.2025)
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("b1")
public class B {
         private A a;
         
         @Autowired
         public void setA(A a) {
        	 System.out.println("B.SetA()");
        	 this.a=a;
         }
         
         //ToString()
         public String toString() {
        	 return "a=";
         }
}
