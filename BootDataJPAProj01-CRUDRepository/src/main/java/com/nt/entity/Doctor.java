//Doctor.java(Entity Class)(26/27/28/01/03/04.02/03.2025)
package com.nt.entity;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
//import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name="JPA_DOCTOR_INFO")
//@RequiredArgsConstructor
public class Doctor {
	  @Id
	  @Column(name="DOC_ID")
	  @SequenceGenerator(name="gen1",sequenceName="JPA_DOCTOR_INFO_SEQ",allocationSize=1,initialValue=100)
	  @GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	  //@GeneratedValue(strategy=GenerationType.AUTO)
	  //@GeneratedValue
	  private Integer docId;
      
      @Column(name="DOC_NAME",length=25)
      @NonNull
      private String docName;
      
      @Column(name="DOC_INCOME")
      @NonNull
      private Long income;
      
      @Column(name="SPECIALIZATION",length=20)
      @NonNull
      //@Transient
      private String specialization;
      
      @Column(name="DOC_MOBILENO")
      @NonNull
      private Long mobileNo;
      
      @Column(name="DOC_QLFY",length=25)
      @NonNull
      private String qlfy;
      
      public Doctor() {
    	  System.out.println("Doctor::0-Param Constructor.");
      }
      public Doctor(String docName, Long income, String specialization,Long mobileNo,String qlfy ) {
          this.docName = docName;
          this.income = income;
          this.specialization = specialization;
          this.mobileNo = mobileNo;
          this.qlfy = qlfy;
      }
}
