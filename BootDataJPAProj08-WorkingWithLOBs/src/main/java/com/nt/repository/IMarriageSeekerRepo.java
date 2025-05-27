//IMarriageSeekerRepo.java(13/14.03.2025)
package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.MarriageSeeker;

public interface IMarriageSeekerRepo extends JpaRepository<MarriageSeeker, Integer> {

}
