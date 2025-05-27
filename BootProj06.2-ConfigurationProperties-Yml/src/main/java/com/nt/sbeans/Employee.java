//Employee.java(18.02.2025)
package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component("emp")
@Data
@ConfigurationProperties(prefix="org.nit")
public class Employee {
        //Simple Properties
	           private Integer eno;
	           private String ename;
	    //Array Type
	           private String[] favColors;
	    //Collection Type
	           private List<String> nickNames;
	           private Set<Long> phoneNumbers;
	           private Map<String,Object> idDetails;
	     //HAS-A Property
	           private Company company;
}
