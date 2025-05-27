//EmployeeVO.java(28.04.2025)
package com.nt.vo;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class EmployeeVO {
     private Integer empno;
     private String ename;
     private String job;	
     private Double sal;
     private Integer deptno ;
     private LocalDateTime hiredate;
}
