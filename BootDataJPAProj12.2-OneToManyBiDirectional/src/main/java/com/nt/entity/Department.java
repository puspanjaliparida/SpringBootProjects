//Department.java(Parent Class)(19.03.2025)
package com.nt.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name="JPA_OTM_BI_DEPT")
@Setter
@Getter
@Entity
public class Department {
    @SequenceGenerator(name="gen1",sequenceName = "dno_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "gen1")
    @Id
	private Integer dno;
    
    @Column(length=30)
    private String dname;
    
    @Column(length=30)
    private String location;
    
    //For One To Many Association (Collection Of HAS-A(Child) Properties)
    @OneToMany(targetEntity=Employee.class,cascade=CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER,mappedBy = "dept")
    //@JoinColumn(name="DEPT_NO",referencedColumnName="DNO")
    private Set<Employee> emps;
    
    public Department() {
    	System.out.println("Department::0-Param Constructor::"+this.getClass());
    }

    //Alt+Shit+S,S
	@Override
	public String toString() {
		return "Department [dno=" + dno + ", dname=" + dname + ", location=" + location +  "]";
	}
    
    
}
