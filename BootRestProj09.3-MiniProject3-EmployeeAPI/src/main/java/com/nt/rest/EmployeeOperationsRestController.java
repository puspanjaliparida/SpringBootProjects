//EmployeeOperationsRestController.java(05.05.2025)
package com.nt.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.EmployeeEntity;
import com.nt.service.IEmployeeMgmtService;
import com.nt.vo.EmployeeVO;

@RestController
@RequestMapping("/emp-api")
public class EmployeeOperationsRestController {
    @Autowired
	private IEmployeeMgmtService empService;
    
    @PostMapping("/register")
    public ResponseEntity<String> registerActor(@RequestBody EmployeeVO vo){
    	try {
    		 //Use Service
    		String msg=empService.insertEmployee(vo);
    		//Return ResponseEntity Object
    		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem In Registration::",
    				                                                                HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @PostMapping("/registerAll")
    public ResponseEntity<String> registerEmployeesInBatch(@RequestBody List<EmployeeVO> listVO){
    	try {
    	//Use Service
    	String msg=empService.insertEmployeesBatch(listVO);
    	//Return ResponseEntity Object
    	return new ResponseEntity<String>(msg,HttpStatus.CREATED);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem In Registration:: "+e.getMessage(),
    				                                                                HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @GetMapping("/all")
    public ResponseEntity<?> fetchAllEmployees(){
    	try {
    		//Use Service
    		Iterable<EmployeeVO> listVO=empService.showAllEmployees();
    		return new ResponseEntity<Iterable<EmployeeVO>>(listVO,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem In Retrieving: "+
    	                                                                           e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @GetMapping("/find/{id}")
    public ResponseEntity<?> fetchEmployeeByEmpno(@PathVariable int empno){
    	try {
    		//Use Service
    		EmployeeVO actor=empService.showEmployeesByEmpno(empno);
    		return new ResponseEntity<EmployeeVO>(actor,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem In Retrieving::"+
    	                                                                            e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @GetMapping("/find/{start}/{end}")
    public ResponseEntity<?> fetchEmployeesBySalaryRange(@PathVariable int start,@PathVariable int end){
    	try {
    		//Use Service
    		Iterable<EmployeeVO> listVO=empService.showEmployeesBySalaryRange(start, end);
    		return new ResponseEntity<Iterable<EmployeeVO>>(listVO,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem In Retrieving::"+
    	                                                                          e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @PutMapping("/update")
    public  ResponseEntity<String>  modifyActor(@RequestBody EmployeeVO vo){
    	//Use Service
    	try {
    		String msg=empService.updateEmployee(vo);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem in Updation::"+
    	                                                                           e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @PatchMapping("/update/{id}/{hikePercentage}")
    public ResponseEntity<String> modifyActor(@PathVariable int empno,@PathVariable double hikePercentage){
    	//Use Service
    	try {
    		String msg=empService.updateEmployeeSalaryByEmpno(empno, hikePercentage);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem in Updation::"+
    	                                                                          e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable int empno){
    	//Use Service
    	try {
    		String msg=empService.removeEmployeesByEmpno(empno);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem in Deletion::",
    				                                                              HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @DeleteMapping("/remove/{start}/{end}")
    public ResponseEntity<String> deleteActorsByFee(@PathVariable double start,@PathVariable double end){
    	//Use Service
    	try {
    		String msg=empService.deleteEmployeesBySalaryRange(start, end);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem in Deletion: "+
    	                                                                           e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}//Class
