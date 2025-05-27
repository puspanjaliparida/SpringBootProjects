//TestBean.java(24.01.2025)
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("tb")
public class TestBean {
     @Autowired
     private Environment env;
     
     public String displayData() {
    	 return "os.name="+env.getProperty("os.name")+"......"+"per.name="+env.getProperty("per.name");
     }
}
