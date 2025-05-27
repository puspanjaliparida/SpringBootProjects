//IPhoneNumberRepository.java(19.03.2025)
package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.PhoneNumber;

public interface IPhoneNumberRepository extends JpaRepository<PhoneNumber,Integer>{

	//@Query("select ph.regno,ph.numberType,ph.phoneNumber,ph.provider,per.pid,per.pname,per.paddrs from PhoneNumber ph inner join ph.person per")
	//@Query("select ph.regno,ph.numberType,ph.phoneNumber,ph.provider,per.pid,per.pname,per.paddrs from PhoneNumber ph right join ph.person per")
	//@Query("select ph.regno,ph.numberType,ph.phoneNumber,ph.provider,per.pid,per.pname,per.paddrs from PhoneNumber ph left join ph.person per")
	@Query("select ph.regno,ph.numberType,ph.phoneNumber,ph.provider,per.pid,per.pname,per.paddrs from PhoneNumber ph full join ph.person per")
	public List<Object[]> showPhoneNumbersAndPersonUsingJoins();
}
