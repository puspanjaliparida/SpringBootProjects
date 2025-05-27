//WishMessageMsService.java(14.05.2025)
package com.nt.ms;

import java.time.LocalTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish-api")
public class WishMessageMsService {

    @GetMapping("/message")
    public ResponseEntity<String> showWishMessage(){
        //generate wish message
        LocalTime time= LocalTime.now();
        //Get Current hour of the day
        int hour=time.getHour();
        String msg=null;
        if(hour<12)
            msg="Good Morning";
        else if(hour<16)
            msg="Good Afternoon";
        else if(hour<20)
            msg="Good Evening";
        else
            msg="Good Night";
        //Return ResponseEntity Object
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
}
