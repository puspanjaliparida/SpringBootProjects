//OTMBiDirectionalAssociationTestRunner.java(19.03.2025)
package com.nt.runner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.service.ICompanyMgmtService;

@Component
public class OTMBiDirectionalAssociationTestRunner implements CommandLineRunner{
     @Autowired
     private ICompanyMgmtService compService;
     
	@Override
	public void run(String... args) throws Exception {
		/*try {
			//Parent Object
			Department dept=new Department();
			dept.setDname("SALES");
			dept.setLocation("hyd");
			
			//Child Objects
			Employee emp1=new Employee();
			emp1.setEname("Raja");
			emp1.setEaddrs("hyd");
			
			Employee emp2=new Employee();
			emp2.setEname("Rajesh");
			emp2.setEaddrs("Vizag");
			
			//Assign Parent To Childs
			emp1.setDept(dept);
			emp2.setDept(dept);
			
			//Assign Childs To Parent
			dept.setEmps(Set.of(emp1,emp2));
			
			//Invoke The Service Method
			String msg=compService.registerDepartment(dept);
			System.out.println(msg);
		}//Try
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			//Parent Object
			Department dept=new Department();
			dept.setDname("IT");
			dept.setLocation("hyd");
			
			//Child Objects
			Employee emp1=new Employee();
			emp1.setEname("Karan");
			emp1.setEaddrs("hyd");
			
			Employee emp2=new Employee();
			emp2.setEname("Chinna");
			emp2.setEaddrs("vizag");
			
			//Assign Parent To Childs
			emp1.setDept(dept);
			emp2.setDept(dept);
			
			//Assign Childs To Parent
			Set<Employee> empsSet=new HashSet<Employee>();
			empsSet.add(emp1);
			empsSet.add(emp2);
			dept.setEmps(empsSet);
			
			//Invoke The Service Method
			String msg=compService.registerEmployees(empsSet);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			//Invoke The Method
			List<Department> deptList=compService.showAllDepartmentsAndItsEmployees();
			deptList.forEach(dept->{
				System.out.println("Depart (Parent)::"+dept);
				Set<Employee> childs=dept.getEmps();
				if(childs!=null) {
					childs.forEach(emp->{
						System.out.println("Employee(Child)::"+emp);
					});
					System.out.println("----------------------------------");
				}
			});
		}//Try
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			//Invoke Service Method
			List<Employee> listEmps=compService.showAllEmployeesAndItsDepartments();
			listEmps.forEach(emp->{
				System.out.println("Employees(Child)::"+emp);
				//Get Depart Of A Employee
				Department dept=emp.getDept();
				System.out.println("Department (Parent)::"+dept);
				System.out.println("----------------------------------------");
			});
		}//Try
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			String msg=compService.removeDepartmentAndItsEmployees(1);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			String msg=compService.removeEmployeesAndTheirDepartment(List.of(52,53));
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			Employee emp1=new Employee();
			emp1.setEname("Mahesh");
			emp1.setEaddrs("Hyd");
			String msg=compService.addNewEmployeeToDepartment(1, emp1);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			String msg=compService.removeAllEmployeesOfADepartment(1);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			String msg=compService.removeOneEmployeeOfADepartment(1, 101);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
