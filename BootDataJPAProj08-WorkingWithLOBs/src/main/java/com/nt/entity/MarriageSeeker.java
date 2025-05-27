//MarriageSeeker.java(13/14.03.2025)
package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
public class MarriageSeeker implements Serializable{
      @Id
      @GeneratedValue
      private Long id;
      
      @NonNull
      @Column(length=20)
      private String name;
      
      @NonNull
      @Column(length=20)
      private String addrs;
      
      @NonNull
      @Lob
      private byte[] photo;
      
      @NonNull
      private LocalDateTime dob;
      
      @NonNull
      @Lob
      private char[] biodata;
      
      @NonNull
      private boolean indian;
}
