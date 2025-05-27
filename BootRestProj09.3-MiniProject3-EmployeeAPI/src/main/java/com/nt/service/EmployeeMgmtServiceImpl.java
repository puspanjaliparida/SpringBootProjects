//EmployeeMgmtServiceImpl.java(05.05.2025)
package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.EmployeeEntity;
import com.nt.repository.IEmployeeRepository;
import com.nt.vo.EmployeeVO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
    @Autowired 
	private IEmployeeRepository empRepo;
    
	@Override
	public String insertEmployee(EmployeeVO empVO) {
        //Convert EmployeeVO Class Object To EmployeeEntity Class Object
		EmployeeEntity empEntity=new EmployeeEntity();
		BeanUtils.copyProperties(empVO, empEntity);
		empEntity.setCreatedBy(System.getProperty("user.name"));
		//Save the Object
		int idVal=empRepo.save(empEntity).getEmpno();
		return "Employee Object Is Saved With Id Value : "+idVal;
	}//Method

	@Override
	public String insertEmployeesBatch(Iterable<EmployeeVO> empsVO) {
		//Convert List<EmployeeVO> to List<EmployeeEntity>Objects
		List<EmployeeEntity> listEntities = new ArrayList();
		empsVO.forEach(vo->{
			EmployeeEntity entity=new EmployeeEntity();
			BeanUtils.copyProperties(vo, entity);
			entity.setCreatedBy(System.getProperty("user.name"));
			listEntities.add(entity);
		});
		//Use SaveAll Objects
		Iterable<EmployeeEntity> savedEntities=empRepo.saveAll(listEntities);
		List<Integer> ids=StreamSupport.stream(savedEntities.spliterator(),false).map(EmployeeEntity::getEmpno).collect(Collectors.toList());
		return ids.size()+"No. Of  Records Are Saved Having Empno Values:: "+ids;
	}//Method

	@Override
	public Iterable<EmployeeVO> showAllEmployees() {
		//Use Service
		Iterable<EmployeeEntity> listEntities=empRepo.findAll();
		//Convert List of Entities To List Of VO Class Objects
		List<EmployeeVO> listVO=new ArrayList();
		listEntities.forEach(entity->{
			EmployeeVO vo=new EmployeeVO();
			BeanUtils.copyProperties(entity, vo);
			listVO.add(vo);
		});
		return listVO;
	}//Method

	@Override
	public EmployeeVO showEmployeesByEmpno(int empno){
		//Load The Object
		EmployeeEntity entity=empRepo.findById(empno).orElseThrow(()-> new IllegalArgumentException("Invalid Empno"));
		//Convert EmployeeEntity Object to EmployeeVO Object
		EmployeeVO vo=new EmployeeVO();
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}//Method

	@Override
	public Iterable<EmployeeVO> showEmployeesBySalaryRange(double startSal,double endSal) {
		// Use Repo
		Iterable<EmployeeEntity> listEntities=empRepo.findEmployeesBySalaryRange(startSal, endSal);
		//Convert ListEntities To listVO
		List<EmployeeVO> listVO=new ArrayList();
		listEntities.forEach(entity->{
			//Convert Each Entity to Each VO class Object
			EmployeeVO vo=new EmployeeVO();
			BeanUtils.copyProperties(entity, vo);
			listVO.add(vo);
		});
		return listVO;
	}//Method

	@Override
	public String updateEmployee(EmployeeVO vo) {
		//Use Repo To Load The Object
		EmployeeEntity entity=empRepo.findById(vo.getEmpno()).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
		//Copy VO Object Data To Entity Object
		BeanUtils.copyProperties(vo, entity);
		entity.setUpdatedBy(System.getProperty("user.name"));
		//Update The Object
		empRepo.save(entity);
		return vo.getEmpno()+" Employee Details Are Updated";
	}//Method

	@Override
	public String updateEmployeeSalaryByEmpno(int empno,double hikePercentage) {
		// Use Repo To Load The Object
		EmployeeEntity entity=empRepo.findById(empno).orElseThrow(()->new IllegalArgumentException("Invalid Empno"));
		entity.setSal(entity.getSal()+(entity.getSal()*hikePercentage/100.0));
		//Update The Object
		empRepo.save(entity);
		return empno+" Employee Fee Is Updated";
	}//Method

	@Override
	public String removeEmployeesByEmpno(int empno) {
		//Load The Object
		EmployeeEntity emp=empRepo.findById(empno).orElseThrow(()->new IllegalArgumentException("Invalid Empno"));
		//Delete the Object
		empRepo.deleteById(empno);
		return empno+" Employee has been Removed.";
	}//Method

	@Override
	public String deleteEmployeesBySalaryRange(double start,double end) {
		// Use Service
		int count=empRepo.removeEmployeeBySalaryRange(start, end);
		return count+" no. of Employees  are removed.";
	}//Method
}//Class
