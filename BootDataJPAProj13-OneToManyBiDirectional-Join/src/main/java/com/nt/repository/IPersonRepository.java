//IPersonRepository.java(19.03.2025)
package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Person;

public interface IPersonRepository extends JpaRepository<Person, Integer> {
   
	//@Query("select per.pid,per.pname,per.paddrs,ph.regno,ph.numberType,ph.phoneNumber,ph.provider From Person per inner join per.phones ph")
	//@Query("select per.pid,per.pname,per.paddrs,ph.regno,ph.numberType,ph.phoneNumber,ph.provider From Person per right join per.phones ph")
	//@Query("select per.pid,per.pname,per.paddrs,ph.regno,ph.numberType,ph.phoneNumber,ph.provider From Person per left join per.phones ph")
	@Query("select per.pid,per.pname,per.paddrs,ph.regno,ph.numberType,ph.phoneNumber,ph.provider From Person per full join per.phones ph")
	public List<Object[]> showPersonAndPhoneNumbersUsingJoins();
}
