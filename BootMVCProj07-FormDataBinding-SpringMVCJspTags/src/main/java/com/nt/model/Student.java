//Student.java(04.04.2025)
package com.nt.model;

import lombok.Data;

@Data
public class Student {
    private Integer sno;
    private String sname;
    private String sadd="hyd";
    private Double avg;
    
    public Student() {
    	System.out.println("Student::0-Param Constructor");
    }
}
