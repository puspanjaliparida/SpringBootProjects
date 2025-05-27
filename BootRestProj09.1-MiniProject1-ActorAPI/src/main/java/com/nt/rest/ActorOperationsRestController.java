//ActorOperationsRestController.java(28/29/30.04.2025)
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

import com.nt.entity.ActorEntity;
import com.nt.service.IActorMgmtService;
import com.nt.vo.ActorVO;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationsRestController {
    @Autowired
	private IActorMgmtService actorService;
    
    @PostMapping("/register")
    public ResponseEntity<String> registerActor(@RequestBody ActorVO vo){
    	try {
    		 //Use Service
    		String msg=actorService.insertActor(vo);
    		//Return ResponseEntity Object
    		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem In Registration::",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @PostMapping("/registerAll")
    public ResponseEntity<String> registerActorsInBatch(@RequestBody List<ActorVO> listVO){
    	try {
    	//Use Service
    	String msg=actorService.insertActorsBatch(listVO);
    	//Return ResponseEntity Object
    	return new ResponseEntity<String>(msg,HttpStatus.CREATED);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem In Registration:: "+e.getMessage(),
    				                                                                HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @GetMapping("/all")
    public ResponseEntity<?> fetchAllActors(){
    	try {
    		//Use Service
    		Iterable<ActorVO> listVO=actorService.showAllActors();
    		return new ResponseEntity<Iterable<ActorVO>>(listVO,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem In Retrieving: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @GetMapping("/find/{id}")
    public ResponseEntity<?> fetchActorById(@PathVariable int id){
    	try {
    		//Use Service
    		ActorVO actor=actorService.showActorsById(id);
    		return new ResponseEntity<ActorVO>(actor,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem In Retrieving::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @GetMapping("/find/{start}/{end}")
    public ResponseEntity<?> fetchActorsByFeeRange(@PathVariable int start,@PathVariable int end){
    	try {
    		//Use Service
    		Iterable<ActorVO> listVO=actorService.showActorsByFeeRange(start, end);
    		return new ResponseEntity<Iterable<ActorVO>>(listVO,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem In Retrieving::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @PutMapping("/update")
    public  ResponseEntity<String>  modifyActor(@RequestBody ActorVO vo){
    	//Use Service
    	try {
    		String msg=actorService.updateActor(vo);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem in Updation::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @PatchMapping("/update/{id}/{hikePercentage}")
    public ResponseEntity<String> modifyActor(@PathVariable int id,@PathVariable double hikePercentage){
    	//Use Service
    	try {
    		String msg=actorService.updateActorFeeById(id, hikePercentage);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem in Updation::"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable int id){
    	//Use Service
    	try {
    		String msg=actorService.removeActorById(id);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem in Deletion::",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }//Method
    
    @DeleteMapping("/remove/{start}/{end}")
    public ResponseEntity<String> deleteActorsByFee(@PathVariable double start,@PathVariable double end){
    	//Use Service
    	try {
    		String msg=actorService.deleteActorsByFeeRange(start, end);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    	}
    	catch(Exception e) {
    		return new ResponseEntity<String>("Problem in Deletion: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}//Class
