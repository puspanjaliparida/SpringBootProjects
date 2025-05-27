//Customer.java(02.04.2025)
package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private Integer cno;
    private String cname;
    private String caddrs;
    private Double billAmt;
}
