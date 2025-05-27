//Actor.java(18.05.2025)
package com.nt.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor implements Serializable{
       private Integer aid;
       private String aname;
       private String addrs;
       private Double fee;
}
