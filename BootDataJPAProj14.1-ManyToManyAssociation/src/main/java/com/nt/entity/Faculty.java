//Faculty.java(21/22.03.2025)
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

@Entity
@Table(name="JPA_MTM_FACULTY1")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Faculty {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "fid_seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator ="gen1",strategy = GenerationType.SEQUENCE)
     private Integer fid;
	@Column(length = 30)
	@NonNull
     private String fname;
	@Column(length = 30)
	@NonNull
     private String faddrs;
	@Column(length = 30)
	@NonNull
     private String subject;
	 @ManyToMany(targetEntity = Student.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 @JoinTable(name="JPA_MTM_FACULTIES_STUDENTS",
	                         joinColumns = @JoinColumn(name="FACULTY_ID",referencedColumnName = "FID"),  //Ownside Fk Column
	                         inverseJoinColumns = @JoinColumn(name="STUDENT_ID",referencedColumnName = "SID")) //Non-Owning Side Fk Column
     private Set<Student> students=new HashSet<Student>();
	 
	 //ToString(Alt+Shift+S,S)
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", faddrs=" + faddrs + ", subject=" + subject + "]";
	}
}
