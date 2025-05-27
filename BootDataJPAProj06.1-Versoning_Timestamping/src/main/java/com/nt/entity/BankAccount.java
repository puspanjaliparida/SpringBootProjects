//BankAccount.java(Entity Class)(11.03.2025)
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

@Table(name="BANK_ACCOUNT")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class BankAccount {
	   @Id
	   @SequenceGenerator(name="gen1",sequenceName="ACNO_SEQ",initialValue=100000000,allocationSize=1)
	   @GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
       private Long acno;
	   
	   @Column(length=20)
	   @NonNull
       private String holderName;
	   
	   @NonNull
       private Double balance;
	   
       @Column(length=20)
       @NonNull
       private String bankName;
       
       @Column(length=10)
       @NonNull
       private String accountType;
       
       //For Versoning
       @Version
       private Integer updateCount;
       
       @CreationTimestamp
       @Column(insertable=true)
       private LocalDateTime openedOn;
       
       @UpdateTimestamp
       @Column(insertable=false)
       private LocalDateTime lastUpdatedOn;
}
