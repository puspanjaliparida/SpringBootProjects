//IDoctorRepository.java(21.03.2025)
package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {

}
