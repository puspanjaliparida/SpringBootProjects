//Printer.java(21.01.2025)
package com.nt.ston;

//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;

//@Component("prn1")
//@Scope("prototype")
public class Printer{
    private   static   Printer  INSTANCE;

   // Private  Constructor
  private  Printer(){
    System.out.println("Printer:: 0-Param Constructor");
    }

   // Static Factory Method
   public   static  Printer   getInstance(){
	   System.out.println("Printer.GetInstance()");
	   
        if(INSTANCE==null)
              INSTANCE=new Printer();
         return  INSTANCE;
    }

  public   void print(String msg){
       System.out.println(msg);
  }
   
}//Class
