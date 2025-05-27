//Movie.java(07.03.2025)
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
@Table(name="MOVIE_INFO")
@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class Movie {
    @Id
    @SequenceGenerator(name="gen1",sequenceName="mov_seq",initialValue=100,allocationSize=1)
    @GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
    //GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="MOV_ID")
    private Integer movId;
    
    @Column(name="MOV_NAME",length=20)
    @NonNull
    private String movName;
    
    @Column(name="MOV_RATING")
    @NonNull
    private Double rating;
    
    @Column(name="MOV_YEAR")
    @NonNull
    private Long movYear;

	public Movie() {
		System.out.println("Movie::0-Param Constructor"+this.getClass()+"------"+this.getClass().getSuperclass());
	}
}
