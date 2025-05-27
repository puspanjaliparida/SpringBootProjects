//CompanyMgmtServiceImpl.java(19.03.2025)
package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.repository.IDepartmentRepository;
import com.nt.repository.IEmployeeRepository;

@Service("companyService")
public class CompanyMgmtServiceImpl implements ICompanyMgmtService{
      @Autowired
      private IDepartmentRepository deptRepo;
      @Autowired
      private IEmployeeRepository empRepo;
      
	@Override
	public String registerDepartment(Department dept) {
		//Save The Parent And Its Child Objects
		int idVal=deptRepo.save(dept).getDno();
		return "Dept And The Associated Employees Are Saved With The Id Value"+idVal;
	}
	
	@Override
	public String registerEmployees(Set<Employee> emps) {
		// Save The Childs Along With It's Parent
		List<Employee> savedList=empRepo.saveAll(emps);
		//Capture Only Ids From The SavedList
		List<Integer> ids=savedList.stream().map(Employee::getEmpno).collect(Collectors.toList());
		return "Employees And The Associated Department Are Saved With The Id Values::"+ids;
	}
	
	@Override
	public List<Department> showAllDepartmentsAndItsEmployees() {
		// Load Parent Objects
		List<Department> deptList=deptRepo.findAll();
		return deptList;
	}
	
	@Override
	public List<Employee> showAllEmployeesAndItsDepartments() {
		// Load Childs Objects
		List<Employee> listEmps=empRepo.findAll();
		return listEmps;
	}
	
	@Override
	public String removeDepartmentAndItsEmployees(int dno) {
		//Load Parent And It's Associated Child Objects
		Optional<Department> opt=deptRepo.findById(dno);
		if(opt.isPresent()) {
			Department dept=opt.get();
			deptRepo.delete(dept);
			return "Department And It's Employees Are Deleted";
		}
		return "Department Is Not Found";
	}
	
	@Override
	public String removeEmployeesAndTheirDepartment(List<Integer> empIds) {
		// Load The Childs By Ids
		List<Employee> listChilds=empRepo.findAllById(empIds);
		if(listChilds!=null && listChilds.size()!=0) {
			empRepo.deleteAll(listChilds);
			return "Given Employees And Their Dept Is Deleted";
		}
		return "Given Employees Are Not Found";
	}
	
	@Override
	public String addNewEmployeeToDepartment(int dno, Employee emp) {
		// Load Department
		Optional<Department> opt=deptRepo.findById(dno);
		if(opt.isPresent()) {
			//Get Department (Parent)
			Department dept=opt.get();
			//Get Collection Of Childs
			Set<Employee> empsSet=dept.getEmps();
			//Set Parent To New Child
			emp.setDept(dept);
			//Add New Child To Parent
			empsSet.add(emp);
			//Save The Parent
			deptRepo.save(dept);
			return "New Employee Is Added To Existing Department";
		}
		return "Department Is Not Found";
	}
	
	@Override
	public String removeAllEmployeesOfADepartment(int dno) {
		// Load Department
		Optional<Department> opt=deptRepo.findById(dno);
		if(opt.isPresent()) {
			//Get Department(Parent)
			Department dept=opt.get(); 
			//Get All Childs(Employees) Of Parent
			Set<Employee> empsSet=dept.getEmps();
			//Nully Dept From Childs(Employees)
			for(Employee emp:empsSet) {
				emp.setDept(null);
			}
			//Delete Only Childs
			empRepo.deleteAllInBatch(empsSet);
			return "All Employees Of The Given Department Are Deleted";
		}
		return "Department Is Not Found";
	}
	@Override
	public String removeOneEmployeeOfADepartment(int dno, int eno) {
		// Load The Parent
		Optional<Department> opt=deptRepo.findById(dno);
		//Load The Child
		Optional<Employee> opt1=empRepo.findById(eno);
		if(opt.isPresent() && opt1.isPresent()) {
			//Get Child(Employee)
			Employee emp=opt1.get();
			//Get Department(Parent)
			Department dept=opt.get();
			//Remove The Link With Parent From Child
			emp.setDept(null);
			//Remove The Child
			empRepo.deleteAllInBatch(List.of(emp));
			return "One Employee From Department Is Deleted";
		}
		return "Given Department Or Given Employee Is Not Found";
	}
      
      
}
