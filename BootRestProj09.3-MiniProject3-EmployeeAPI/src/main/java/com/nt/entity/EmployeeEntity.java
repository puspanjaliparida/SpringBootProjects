//EmployeeEntity.java(05.05.2025)
package com.nt.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="REST_EMP")
public class EmployeeEntity {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "emp_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
     private Integer empno;
	
	@NonNull
	@Column(length = 30)
     private String ename;
	
	@NonNull
	@Column(length = 30)
     private String job;
	
     private Double sal;
   
     private Integer deptno;
     
     @NonNull
     private LocalDateTime hiredate;
     
     @Version
     private Integer updateCount;
     
     @CreationTimestamp
     @Column(updatable = false)
     private LocalDateTime creationTime;
     
     @UpdateTimestamp
     @Column(insertable = false)
     private LocalDateTime lastupdateTime;
     
     @Column(length = 30)
     private String createdBy;
     
     @Column(length = 30)
     private String updatedBy;
     
     @Column(length = 30)
     private String status="active";
}
