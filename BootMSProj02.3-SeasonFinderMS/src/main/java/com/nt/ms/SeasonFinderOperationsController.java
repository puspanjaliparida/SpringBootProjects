//SeasonFinderOperationsController.java(14.05.2025)
package com.nt.ms;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/season-api")
public class SeasonFinderOperationsController {
      @Value("${spring.application.instance-id}")
      private String instance_id;
      
      //Rest Operation/endpoint
      @GetMapping("/show-season")
      public ResponseEntity<String> findSeason(){
    	  //Get Local Date and Time
    	  LocalDateTime ldt=LocalDateTime.now();
    	  //Get Current Month
    	  int month=ldt.getMonthValue();
    	  String seasonName=null;
    	  if(month>=7 && month<=10)
    		  seasonName="Rainy Season";
    	  else if(month>=3 && month<=6)
    		  seasonName="Summer Season";
    	  else
    		  seasonName="Winter Season";
    	  //Improve the output
    	  seasonName=seasonName+"......"+instance_id;
    	  //Return The ResponseEntity Object
    	  return new ResponseEntity<String>(seasonName,HttpStatus.OK);
      }
}
