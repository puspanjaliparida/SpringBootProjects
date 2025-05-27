//JobSeeker.java(12.03.2025)
package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JOBSEEKER_JODA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class JobSeeker {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
     private Integer jsId;
	
	@NonNull
	@Column(length=30)
     private String jsName;
	
	@NonNull
	@Column(length=30)
     private String jsAddrs;
	
	@NonNull
     private LocalDateTime dob;
	
	@NonNull
     private LocalTime tob;
	
	@NonNull
     private LocalDate doj;
}
