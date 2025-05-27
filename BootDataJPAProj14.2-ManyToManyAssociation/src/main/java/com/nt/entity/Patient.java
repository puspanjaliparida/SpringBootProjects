//Patient.java(21.03.2025)
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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name="JPA_MTM_PATIENT")
@Entity
@Setter
@Getter
public class Patient {
	  @Id
	  @SequenceGenerator(name="gen1",sequenceName = "PATID_SEQ",initialValue = 1000,allocationSize = 1)
	  @GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
      private Integer patid;
	  @Column(length=30)
      private String pname;
	  @Column(length=30)
      private String problem;
	  
	  @ManyToMany(targetEntity = Doctor.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	  @JoinTable(name="JPA_MTM_PATIENTS_DOCTORS",joinColumns = @JoinColumn(name="PATIENT_ID",referencedColumnName ="PATID" ),
	                          inverseJoinColumns = @JoinColumn(name="DOCTOR_ID",referencedColumnName = "DID"))
	  private List<Doctor> doctors;

	  //ToString(Alt+Shift+S,S)
	@Override
	public String toString() {
		return "Patient [patid=" + patid + ", pname=" + pname + ", problem=" + problem + "]";
	}  
}
