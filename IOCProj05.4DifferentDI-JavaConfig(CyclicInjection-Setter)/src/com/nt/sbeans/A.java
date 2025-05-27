//A.java(05.01.2025)
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("a1")
public class A {
       private B b;
       
       @Autowired
       public void setB(B b) {
    	   System.out.println("A.SetB()");
    	   this.b=b;
       }
       
       //ToString()
       @Override
       public String toString() {
    	   return "b=";
       }
}
