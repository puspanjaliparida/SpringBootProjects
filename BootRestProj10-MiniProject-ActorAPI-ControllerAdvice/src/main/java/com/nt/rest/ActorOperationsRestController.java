//ActorOperationsRestController.java(30.04.2025)
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
    		 //Use Service
    		String msg=actorService.insertActor(vo);
    		//Return ResponseEntity Object
    		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
    }//Method
    
    @PostMapping("/registerAll")
    public ResponseEntity<String> registerActorsInBatch(@RequestBody List<ActorVO> listVO){
    	//Use Service
    	String msg=actorService.insertActorsBatch(listVO);
    	//Return ResponseEntity Object
    	return new ResponseEntity<String>(msg,HttpStatus.CREATED);
    }//Method
    
    @GetMapping("/all")
    public ResponseEntity<Iterable<ActorVO>> fetchAllActors(){
    		//Use Service
    		Iterable<ActorVO> listVO=actorService.showAllActors();
    		return new ResponseEntity<Iterable<ActorVO>>(listVO,HttpStatus.OK);
    }//Method
    
    @GetMapping("/find/{id}")
    public ResponseEntity<ActorVO> fetchActorById(@PathVariable int id){
    		//Use Service
    		ActorVO actor=actorService.showActorsById(id);
    		return new ResponseEntity<ActorVO>(actor,HttpStatus.OK);
    }//Method
    
    @GetMapping("/find/{start}/{end}")
    public ResponseEntity<Iterable<ActorVO>> fetchActorsByFeeRange(@PathVariable int start,@PathVariable int end){
    		//Use Service
    		Iterable<ActorVO> listVO=actorService.showActorsByFeeRange(start, end);
    		return new ResponseEntity<Iterable<ActorVO>>(listVO,HttpStatus.OK);
    }//Method
    
    @PutMapping("/update")
    public  ResponseEntity<String>  modifyActor(@RequestBody ActorVO vo){
    	//Use Service
    		String msg=actorService.updateActor(vo);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    }//Method
    
    @PatchMapping("/update/{id}/{hikePercentage}")
    public ResponseEntity<String> modifyActor(@PathVariable int id,@PathVariable double hikePercentage){
    	//Use Service
    		String msg=actorService.updateActorFeeById(id, hikePercentage);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    }//Method
    
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteActor(@PathVariable int id){
    	//Use Service
    		String msg=actorService.removeActorById(id);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    }//Method
    
    @DeleteMapping("/remove/{start}/{end}")
    public ResponseEntity<String> deleteActorsByFee(@PathVariable double start,@PathVariable double end){
    	//Use Service
    		String msg=actorService.deleteActorsByFeeRange(start, end);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    }
}//Class
