//StudentOperationsController.java(24/25.04.2025)
package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student-api")
public class StudentOperationsController {
    
	/*@GetMapping("/report/{sno}/{sname}/{sadd}")
	public ResponseEntity<String>  showStudentData(@PathVariable("sno") int no,
			                                                                                            @PathVariable("sname") String name,
			                                                                                            @PathVariable String sadd){
		System.out.println("Path Variable Values Are:: "+no+"..."+name+"..."+sadd);
		return new ResponseEntity<String>("Path Variable Values:: "+no+"..."+name+"..."+sadd,HttpStatus.OK);
	}*/
	
	/*@GetMapping({"/report/{sno}/{sname}/{sadd}","/report/{sno}/{sname}","/report/{sno}","/report"})
	public ResponseEntity<String>  showStudentData(@PathVariable(name="sno",required = false) int no,
			                                                                                            @PathVariable(name="sname",required = false) String name,
			                                                                                            @PathVariable(required = false) String sadd){
		System.out.println("Path Variable Values Are:: "+no+"..."+name+"..."+sadd);
		return new ResponseEntity<String>("Path Variable Values:: "+no+"..."+name+"..."+sadd,HttpStatus.OK);
	}*/
	
	@GetMapping("/report/no/name")
	public String fetchData1(@PathVariable(name="name",required = false) String sname,
			                                          @PathVariable(required = false) Integer no) {
		return "fromFetchData1";
	}
	
	@GetMapping("/report/no/{name}")
	public String fetchData2(@PathVariable(name="name",required = false) String sname,
			                                          @PathVariable(required = false) Integer no) {
		return "fromFetchData2";
	}
	
	@GetMapping("/report/{no}/{name}")
	public String fetchData3(@PathVariable(name="name",required = false) String sname,
			                                          @PathVariable(required = false) Integer no) {
		return "fromFetchData3";
	}
	
	@GetMapping("/report/{no}/name")
	public String fetchData4(@PathVariable(name="name",required = false) String sname,
			                                          @PathVariable(required = false) Integer no) {
		return "fromFetchData4";
	}
}
