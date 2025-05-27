//JobSeeker.java(07.03.2025)
package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JOB_SEEKER_INFO")
@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class JobSeeker {
    @Id
    @SequenceGenerator(name="gen1",sequenceName="jsld_seq",initialValue=100,allocationSize=1)
    @GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
    //GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="JS_ID")
    private Integer jsid;
    
    @Column(name="JS_NAME",length=20)
    @NonNull
    private String jsName;
    
    @Column(name="JS_QLFY",length=20)
    @NonNull
    private String qlfy;
    
    @Column(name="JS_PERCENTAGE")
    @NonNull
    private Double percentage;
    
    @Column(name="JS_CONTACT_INFO")
    @NonNull
    private Long mobileNo;

	public JobSeeker() {
		System.out.println("JobSeeker::0-Param Constructor::"+this.getClass()+"------"+this.getClass().getSuperclass());
	}
}
