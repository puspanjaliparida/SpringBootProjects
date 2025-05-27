//IDoctorRepository.java(07.03.2025)
package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
     public List<Doctor> findBySpecializationEquals(String speciality);
     public List<Doctor> readBySpecializationEquals(String speciality);
     public List<Doctor> getBySpecializationEquals(String speciality);
     public List<Doctor> findBySpecializationIs(String speciality);
     public List<Doctor> findBySpecialization(String speciality);
     
     public Iterable<Doctor> findByDocNameStartingWith(String letters);
     public Iterable<Doctor> findByDocNameEndingWith(String letters);
     public Iterable<Doctor> findByDocNameContaining(String letters);
     public Iterable<Doctor> findByDocNameLike(String letters);

     public Iterable<Doctor> findByIncomeBetween(double start,double end);
     public Iterable<Doctor> findByIncomeGreaterThanAndIncomeLessThan(double start,double end);
     public Iterable<Doctor> findBySpecializationEqualsIgnoreCase(String speciality);
     public Iterable<Doctor> findBySpecializationEqualsIgnoreCaseOrderByDocNameAsc(String speciality);
}
