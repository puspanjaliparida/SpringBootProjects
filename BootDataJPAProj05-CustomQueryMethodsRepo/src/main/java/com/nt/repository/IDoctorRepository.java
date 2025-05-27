//IDoctorRepository.java(08/10/11.03.2025)
package com.nt.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	//@Query("FROM Doctor")
	//@Query("FROM Doctor doc")
	//@Query("FROM Doctor as doc")
	/*@Query("SELECT doc FROM Doctor as doc")
     public List<Doctor> showAllDoctors();*/
	
	 /*@Query("FROM Doctor WHERE specialization in(?1,?2,?3) order by specialization")
	 public List<Doctor> showAllDoctorsBySpecialization(String speciality1,String speciality2,String speciality3);*/
	
	 /*@Query("FROM Doctor WHERE specialization in(?0,?1,?3) order by specialization")
	 public List<Doctor> showAllDoctorsBySpecialization(String speciality1,String speciality2,String speciality3);*/
	 
	/*@Query("FROM Doctor WHERE specialization in(:special1,:special2,:special3) order by specialization")
	 public List<Doctor> showAllDoctorsBySpecialization(@Param("special1")String speciality1,
			                                                                                                  @Param("special2")String speciality2,
			                                                                                                  @Param("special3")String speciality3);*/
    /*Valid
	@Query("FROM Doctor WHERE specialization in(:special1,:special2,:special3) order by specialization")
	 public List<Doctor> showAllDoctorsBySpecialization(String special1,String special2,String special3);
	
	@Query("FROM Doctor WHERE specialization in(?1,:special2,:special3) order by specialization")
	 public List<Doctor> showAllDoctorsBySpecialization(String special1,String special2,String special3);
	
	@Query("FROM Doctor WHERE specialization in(?1,?2,:special3) order by specialization")
	 public List<Doctor> showAllDoctorsBySpecialization(String special1,String special2,String special3);*/
	
	/*Invalid
	@Query("FROM Doctor WHERE specialization in(:special1,?2,:special3) order by specialization")
	 public List<Doctor> showAllDoctorsBySpecialization(String special1,String special2,String special3);*/
	
	@Query("FROM  Doctor WHERE income>=:startRange and income<=:endRange order by income desc")//Bulk Entity
	public List<Doctor> showDoctorsByIncome(double startRange,double endRange);
	
	@Query("SELECT docId,docName,qlfy FROM  Doctor WHERE qlfy in(:qlfy1,:qlfy2,:qlfy3)")//Bulk Scalar/Projection Query Selecting Specific Multiple Column Values
	public List<Object[]> showDoctorsDataByQualifications(String qlfy1,String qlfy2,String qlfy3);
    
	@Query("SELECT docName FROM  Doctor WHERE specialization=:speciality")//Bulk Scalar/Projection Query Giving Single Column Value
	public List<String> showDoctorsNameBySpecialization(String speciality);
	
	//Single Row Entity Query
	@Query("FROM Doctor WHERE docName=:name")
	public Doctor showDoctorDetailsByName(String name);
	
	//Single Row Scalar Query(Specific Multiple Column Values)
	@Query("SELECT docId,docName,income FROM Doctor WHERE docName=:name")
	public Object showDoctorDataByName(String name);
	
	//Single Row Scalar Query(Specific Single Column Values)
	@Query("SELECT income FROM Doctor WHERE docName=:name")
	public Double showDoctorIncomeByName(String name);
	
	//Aggregate Operation(Here Distinct Count And (Distinct docName) Both Are Possible
	@Query("SELECT  COUNT(DISTINCT docName) FROM Doctor")
	public long showUniqueDoctorsCount();
	
	@Query("SELECT COUNT(*),MAX(income),MIN(income),SUM(income),AVG(income) FROM Doctor")
	public Object showDoctorsAggregateData();
	
	//--------------------------------------------------------NON-SELECT Operations-----------------------------------------------------------//
	/*@Query("UPDATE Doctor SET income=income+(income*(?1))WHERE specialization in(:speciality1,:speciality2)")
	@Modifying
	@Transactional
	public int updateDoctorsIncomeBySpecializations(double hikePercent,String speciality1,String speciality2);*/
	
	@Query("UPDATE Doctor SET income=:newIncome WHERE specialization in(:speciality1,:speciality2)")
	@Modifying
	@Transactional
	public int updateDoctorsIncomeBySpecializations(double newIncome,String speciality1,String speciality2);
	
	@Query("DELETE FROM  Doctor WHERE income>=:start and income<=:end")
	@Modifying
	@Transactional
	public int removeDoctorsByIncomeRange(double start,double end);
	
	//-------------------------------------------NATIVE SQL QUERY-------------------------------------//
	@Query(value="SELECT now() FROM dual",nativeQuery=true)
	public LocalDateTime showSystemDateAndTime();
	
	@Query(value="INSERT INTO JPA_DOCTOR_INFO(doc_id,doc_name,doc_income,specialization) VALUES(:id,:name,:income,:speciality)",nativeQuery=true)
	@Transactional
	@Modifying
	public int registerDoctor(int id,String name,double income,String speciality);
	
	@Query(value="CREATE TABLE Temp(col1 integer,col2 varchar(20))",nativeQuery=true)
	@Modifying
	@Transactional
	public int createTempTable();
}
