//Person.java(Parent Class)(19.03.2025)
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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(name="JPA_OTM_BI_PERSON")
@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class Person {
	@Id
	@SequenceGenerator(name="gen1",sequenceName="PID_SEQ1",initialValue=1000,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
    private Integer pid;
	
	@NonNull
	@Column(length=30)
    private String pname;
	
	@NonNull
	@Column(length=30)
    private String paddrs;
	
	@OneToMany(targetEntity=PhoneNumber.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy  = "person")
	//@JoinColumn(name="PERSON_ID",referencedColumnName = "PID")
	private Set<PhoneNumber> phones;

	public Person() {
		System.out.println("Person::0-Param Constructor"+this.getClass());
	}
	//ToString(Alt+Shift+S,S)
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	
}
