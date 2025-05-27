//Company.java(17.02.2025)
package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Setter;
import lombok.ToString;

@Component("comp")
@Setter
@ToString
@ConfigurationProperties(prefix="org.nit")
public class Company {
         private String name;
         private String addrs;
         private Long pincode;
         private Long contact;
         
         private String[] branches;
         private List<String> owners;
         private Set<Long> phones;
         
         private Map<String,Object> idDetails;
         private License licenseDetails;  //(HAS-A Property)
}
