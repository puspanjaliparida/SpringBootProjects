//ActorOperationsRestController.java(30.04.2025)
package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.nt.service.IActorMgmtService;
import com.nt.vo.ActorVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;

@RestController
@RequestMapping("/actor-api")
@Tag(name="ActorAPI",description = "Operations related to Actor Management ")
public class ActorOperationsRestController {
    @Autowired
	private IActorMgmtService actorService;
    
    @PostMapping("/register")
    @Operation(
    		summary = "Actor Registration",
    		description = "Actor Registration takes place."
    		)
    @ApiResponses(value= {
    		@ApiResponse(responseCode = "201",description = "Actor Created",
    		content= {@Content(mediaType="application/json",
    		schema=@Schema(implementation = ActorVO.class)
    		)})})
     public ResponseEntity<String> registerActor(@RequestBody ActorVO vo){
    		     //Use Service
    		    String msg=actorService.insertActor(vo);
    		    //Return ResponseEntity Object
    		    return new ResponseEntity<String>(msg,HttpStatus.CREATED);
     }//Method
    
       
        @PostMapping("/registerAll")
        @Operation(
        		summary = "Actors Registration",
        		description = "Actors Registration takes place."
        		)
        @ApiResponses(value= {
        		@ApiResponse(responseCode = "201",description = "Actors are  Created",
        		content= {@Content(mediaType="application/json",
        		schema=@Schema(implementation = ActorVO.class)
        		)})})
         public ResponseEntity<String> registerActorsInBatch(@RequestBody List<ActorVO> listVO){
    	         //Use Service
    	         String msg=actorService.insertActorsBatch(listVO);
    	        //Return ResponseEntity Object
    	        return new ResponseEntity<String>(msg,HttpStatus.CREATED);
         }//Method
    
        
    @GetMapping("/all")
    @Operation(
    		summary = "Retrieve Actors",
    		description = "Retrieving of Actors are takes place."
    		)
    @ApiResponses(value= {
    		@ApiResponse(responseCode = "201",description = "Actors Retrieved",
    		content= {@Content(mediaType="application/json",
    		schema=@Schema(implementation = ActorVO.class)
    		)})})
    public ResponseEntity<Iterable<ActorVO>> fetchAllActors(){
    		//Use Service
    		Iterable<ActorVO> listVO=actorService.showAllActors();
    		return new ResponseEntity<Iterable<ActorVO>>(listVO,HttpStatus.OK);
    }//Method
    
    
    @GetMapping("/find/{id}")
    @Operation(
    		summary = "Retrieve Actor",
    		description = "Rtrieving of Actor takes place."
    		)
    @ApiResponses(value= {
    		@ApiResponse(responseCode = "201",description = "Actor Retrieved",
    		content= {@Content(mediaType="application/json",
    		schema=@Schema(implementation = ActorVO.class)
    		)})})
    public ResponseEntity<ActorVO> fetchActorById(@PathVariable int id){
    		//Use Service
    		ActorVO actor=actorService.showActorsById(id);
    		return new ResponseEntity<ActorVO>(actor,HttpStatus.OK);
    }//Method
    
    
    @GetMapping("/find/{start}/{end}")
    @Operation(
    		summary = "RetrieveActorByFeeRange",
    		description = "Actors are Retrieved According to FeeRange"
    		)
    @ApiResponses(value= {
    		@ApiResponse(responseCode = "201",description = "Actors Retrieved",
    		content= {@Content(mediaType="application/json",
    		schema=@Schema(implementation = ActorVO.class)
    		)})})
    public ResponseEntity<Iterable<ActorVO>> fetchActorsByFeeRange(@PathVariable int start,@PathVariable int end){
    		//Use Service
    		Iterable<ActorVO> listVO=actorService.showActorsByFeeRange(start, end);
    		return new ResponseEntity<Iterable<ActorVO>>(listVO,HttpStatus.OK);
    }//Method
    
    
    @PutMapping("/update")
    @Operation(
    		summary = "Actor Updation",
    		description = "Actor Updation takes place."
    		)
    @ApiResponses(value= {
    		@ApiResponse(responseCode = "201",description = "Actor Updated",
    		content= {@Content(mediaType="application/json",
    		schema=@Schema(implementation = ActorVO.class)
    		)})})
    public  ResponseEntity<String>  modifyActor(@RequestBody ActorVO vo){
    	//Use Service
    		String msg=actorService.updateActor(vo);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    }//Method
    
    
    @PatchMapping("/update/{id}/{hikePercentage}")
    @Operation(
    		summary = "ActorUpdationByHikePercentage",
    		description = "Actor Updation takes place using HikePercentage(PATCH)"
    		)
    @ApiResponses(value= {
    		@ApiResponse(responseCode = "201",description = "Actor Updated",
    		content= {@Content(mediaType="application/json",
    		schema=@Schema(implementation = ActorVO.class)
    		)})})
    public ResponseEntity<String> modifyActor(@PathVariable int id,@PathVariable double hikePercentage){
    	//Use Service
    		String msg=actorService.updateActorFeeById(id, hikePercentage);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    }//Method
    
    
    @DeleteMapping("/remove/{id}")
    @Operation(
    		summary = "Actor Deletion",
    		description = "Actor Deletion takes place."
    		)
    @ApiResponses(value= {
    		@ApiResponse(responseCode = "201",description = "Actor Deleted",
    		content= {@Content(mediaType="application/json",
    		schema=@Schema(implementation = ActorVO.class)
    		)})})
    public ResponseEntity<String> deleteActor(@PathVariable int id){
    	//Use Service
    		String msg=actorService.removeActorById(id);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    }//Method
    
    
    @DeleteMapping("/remove/{start}/{end}")
    @Operation(
    		summary = "ActorDeletionByFeeRange",
    		description = "Actor Deletion takes place using FeeRange."
    		)
    @ApiResponses(value= {
    		@ApiResponse(responseCode = "201",description = "Actors Deleted",
    		content= {@Content(mediaType="application/json",
    		schema=@Schema(implementation = ActorVO.class)
    		)})})
    public ResponseEntity<String> deleteActorsByFee(@PathVariable double start,@PathVariable double end){
    	//Use Service
    		String msg=actorService.deleteActorsByFeeRange(start, end);
    		return new ResponseEntity<String>(msg,HttpStatus.OK);
    }
}//Class
