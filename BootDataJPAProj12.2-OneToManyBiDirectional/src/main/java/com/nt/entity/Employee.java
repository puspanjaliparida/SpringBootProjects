//Employee.java(19.03.2025)
package com.nt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="JPA_OTM_BI_EMPLOYEE")
@Getter
@Setter
public class Employee {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
       private Integer empno;
	  @Column(length=30)
       private String ename;
	  @Column(length=30)
       private String eaddrs;
	  
	  //Build Many To One Association(HAS-A Property)
	  @ManyToOne(targetEntity = Department.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	  @JoinColumn(name="DEPT_NO",referencedColumnName = "DNO")
	  private Department dept;
	  
	  public Employee() {
		  System.out.println("Employee::0-Param Constructor::"+this.getClass());
	  }

	  //Alt+Shift+S,S
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", eaddrs=" + eaddrs + "]";
	}
	  
	  
}
