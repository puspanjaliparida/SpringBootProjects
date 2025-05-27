//Employee_Date_Time.java(12.03.2025)
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
@Table(name="Employee_Date_Time")
@Entity()
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee_Date_Time {
     @GeneratedValue(strategy=GenerationType.AUTO)
     @Id
     private Integer eno;
     
     @NonNull
     private String ename;
     
     @NonNull
     private String desg;
     
     @NonNull
     private LocalDateTime dob;
     
     @NonNull
     private LocalTime toj;
     
     @NonNull
     private LocalDate doj;
}
