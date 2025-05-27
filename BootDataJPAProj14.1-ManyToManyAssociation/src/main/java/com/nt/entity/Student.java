//Student.java(21/22.03.2025)
package com.nt.entity;

import java.util.HashSet;
import java.util.Set;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Table(name="JPA_MTM_STUDENT")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {
  @Id
  @SequenceGenerator(name="gen1",sequenceName = "SID_SEQ",initialValue = 100,allocationSize = 1)
  @GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
   private Integer sid;
   @Column(length=30)
   @NonNull
   private String sname;
   @Column(length=30)
   @NonNull
   private String addrs;
   @Column(length=30)
   @NonNull
   private String course;
	@ManyToMany(targetEntity = Faculty.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="JPA_MTM_FACULTIES_STUDENTS",
	                       joinColumns = @JoinColumn(name="STUDENT_ID",referencedColumnName = "SID"),
	                       inverseJoinColumns = @JoinColumn(name="FACULTY_ID",referencedColumnName = "FID"))
   private Set<Faculty> faculties=new HashSet<Faculty>();
	
	//ToString(Alt+Shift+S,S)
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", addrs=" + addrs + ", course=" + course + "]";
	}
}
