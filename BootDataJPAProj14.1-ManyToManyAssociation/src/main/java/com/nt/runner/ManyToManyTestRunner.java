//ManyToManyTestRunner.java(21/22.03.2025)
package com.nt.runner;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Faculty;
import com.nt.entity.Student;
import com.nt.service.ICollegeMgmtService;

@Component
public class ManyToManyTestRunner implements CommandLineRunner {

	@Autowired
	private ICollegeMgmtService collegeService;
	
	@Override
	public void run(String... args) throws Exception {
		/*try {
			Student st1=new Student("Rahul","hyd","cs");
			Student st2=new Student("Ballu","hyd","civil");
			Student st3=new Student("Sunil","hyd","me");
			
			Faculty fc1=new Faculty("kiran","hyd","java");
			Faculty fc2=new Faculty("Rajib","hyd","ui");
			
			//Assign Students To The Faculties
			fc1.getStudents().add(st1);
			fc1.getStudents().add(st2);
			
			fc2.getStudents().add(st1);
			fc2.getStudents().add(st2);
			fc2.getStudents().add(st3);
			
			//Assign Faculties To Students
			st1.getFaculties().add(fc1);
			st1.getFaculties().add(fc2);
			
			st2.getFaculties().add(fc1);
			st2.getFaculties().add(fc2);
			
			st3.getFaculties().add(fc2);
			
			//Invoke The Method
			String msg=collegeService.registerDetailsUsingFacultiesInfo(Arrays.asList(fc1,fc2));
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			Student st1=new Student("suraj","hyd","cs");
			Student st2=new Student("bidya","hyd","civil");
			Student st3=new Student("farhaan","hyd","me");
			
			Faculty fc1=new Faculty("abhika","hyd","java");
			Faculty fc2=new Faculty("divyani","hyd","ui");
			
			//Assign Faculties To Students
			st1.getFaculties().add(fc1);
			st1.getFaculties().add(fc2);
			
			st2.getFaculties().add(fc1);
			st2.getFaculties().add(fc2);
			
			st3.getFaculties().add(fc2);

			//Assign Students To The Faculties
			fc1.getStudents().add(st1);
			fc1.getStudents().add(st2);
			
			fc2.getStudents().add(st1);
			fc2.getStudents().add(st2);
			fc2.getStudents().add(st3);
			
			//Invoke The Method
			String msg=collegeService.registerFacultiesUsingStudentsInfo(Arrays.asList(st1,st2,st3));
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			collegeService.showFacultiesAndTheirStudents().forEach(fac->{
				System.out.println("Parent::"+fac);
				//Get Childs Of Each Parent
				Set<Student> list=fac.getStudents();
				list.forEach(stud->{
					System.out.println("Child::"+stud);
				});
			});
		}//Try
		catch(Exception e) {
			e.printStackTrace();
	    }*/
		
		/*try {
			collegeService.showStudentsAndTheirFaculties().forEach(stud->{
				System.out.println("Child::"+stud);
				//Get Childs Of Each Parent
				Set<Faculty> list=stud.getFaculties();
				list.forEach(fac->{
					System.out.println("Child::"+fac);
				});
			});
		}//Try
		catch(Exception e) {
			e.printStackTrace();
	    }*/
		
		try {
			String msg=collegeService.removeCertainStudentsFromFaculties(1000, 100, 101);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
