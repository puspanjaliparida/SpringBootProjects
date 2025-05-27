//Employee.java(13.04.2025)
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
@Table(name="EMP")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {
	
	  @Id
	  @SequenceGenerator(name="gen1",sequenceName = "Emp_Seq",initialValue = 1000,allocationSize = 1)
	  @GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
      private Integer empno;
      
      @Column(length = 30)
      @NonNull
      private String ename;
      
      @Column(length = 20)
      @NonNull
      private String job;
      
      @NonNull
      private Double sal;
      
      @NonNull
      private Integer deptno;
      
      //METADATA Columns
      @CreationTimestamp
      @Column(updatable=false)
      private LocalDateTime  createDate; //Timestamp Feature
      
      @UpdateTimestamp
      @Column(insertable =false)
      private LocalDateTime  updateDate; //Timestamp Feature
      
      @Version
      private Integer updateCount; //Versoning Feature
      
      @Column(length = 20,updatable = false)
      private String createdBy;
      @Column(length = 20,insertable = false)
      private String updatedBy;
}
