//PhoneNumber.java(Child Class)(19.03.2025)
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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(name="JPA_OTM_BI_PHONENUMBER")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class PhoneNumber {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer regno;
	
	@NonNull
	@Column(length=30)
	private String numberType;
	
	@NonNull
	private Long phoneNumber;
	
	@Column(length=30)
	@NonNull
	private String provider;
	
	@ManyToOne(targetEntity =Person.class,cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="PERSON_ID",referencedColumnName = "PID")
	private Person person;
	
	public PhoneNumber() {
		System.out.println("PhoneNumber::0-Param Constructor"+this.getClass());
	}
	
	//ToString()(Alt+Shift+S,S)
	@Override
	public String toString() {
		return "PhoneNumber [regno=" + regno + ", numberType=" + numberType + ", phoneNumber=" + phoneNumber
				+ ", provider=" + provider + "]";
	}
}
