//IDoctorRepository.java(04/05.03.2025)
package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Doctor;

public interface IDoctorRepository extends CrudRepository<Doctor, Integer>, PagingAndSortingRepository<Doctor, Integer> {

}
