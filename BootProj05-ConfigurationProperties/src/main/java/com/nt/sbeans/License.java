//License.java(17.02.2025)
package com.nt.sbeans;

import java.util.Set;
import lombok.Data;

@Data
public class License {
      private Integer lid;
      private String type;
      private String issuedBy;
      private Set<Long> phones;
}
