//IStudentRepository.java(21/22.03.2025)
package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
