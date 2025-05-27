//PersonDetails.java(24.01.2025)
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pDetails")
public class PersonDetails {
	//Injecting  The Values From The Properties File
	@Value("${per.id}")
      private int pid;
	@Value("${per.name}")
	  private String pname;
	@Value("${per.addrs}")
	  private String paddrs;
	@Value("${per.age}")
	  private Integer page;
	//Hard Coding Of The Values
	@Value("raja@rani.com")
	  private String email;
	//Injecting The System Property Values
	 @Value("${os.name}")
	  private String osName;
	 @Value("${os.version}")
	  private String osVersion;
	 //Injecting Environment Variable Values
	 @Value("${Path}")
	  private String pathData;
	 
	 //ToString(Alt+Shift+s,s)
	@Override
	public String toString() {
		return "PersonDetails [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", page=" + page + ", email="
				+ email + ", osName=" + osName + ", osVersion=" + osVersion + ", pathData=" + pathData + "]";
	}
	 
}
