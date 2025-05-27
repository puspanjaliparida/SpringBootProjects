//Doctor.java(21.03.2025)
package com.nt.entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name="JPA_MTM_DOCTOR")
@Entity
@Getter
@Setter
public class Doctor {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
      private Integer did;
	  @Column(length=30)
      private String name;
	  @Column(length=30)
      private String specialization;
	  
	  @ManyToMany(targetEntity = Patient.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	  @JoinTable(name="JPA_MTM_PATIENTS_DOCTORS",joinColumns = @JoinColumn(name="DOCTOR_ID",referencedColumnName ="DID" ),
	                          inverseJoinColumns = @JoinColumn(name="PATIENT_ID",referencedColumnName = "PATID") )
	  private List<Patient> patients;

	  //ToString(Alt+Shift+S,S)
	@Override
	public String toString() {
		return "Doctor [did=" + did + ", name=" + name + ", specialization=" + specialization + "]";
	}
}
