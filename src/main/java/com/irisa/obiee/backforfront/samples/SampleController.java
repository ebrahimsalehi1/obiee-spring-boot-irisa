package com.irisa.obiee.backforfront.samples;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @RequestMapping(value = "/getdata",method = RequestMethod.GET)
    public ResponseEntity<String> getData() {
        return new ResponseEntity<>("I am Ebrahim Salehi", HttpStatus.OK);
    }

    @RequestMapping(value="/gettype/{type}",method = RequestMethod.GET)
    public ResponseEntity<String> getType(@PathVariable Integer type){
        switch(type){
            case 1:
                return new ResponseEntity<>("ACCEPTED",HttpStatus.ACCEPTED);
            case 2:
                return new ResponseEntity<>("EXPECTATION_FAILED",HttpStatus.EXPECTATION_FAILED);
            case 3:
                return new ResponseEntity<>("ALREADY_REPORTED",HttpStatus.ALREADY_REPORTED);
            case 4:
                return new ResponseEntity<>("BAD_GATEWAY",HttpStatus.BAD_GATEWAY);
            case 5:
                return new ResponseEntity<>("BANDWIDTH_LIMIT_EXCEEDED",HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
            case 6:
                return new ResponseEntity<>("CHECKPOINT",HttpStatus.CHECKPOINT);
            case 7:
                return new ResponseEntity<>("CONFLICT",HttpStatus.CONFLICT);
            case 8:
                return new ResponseEntity<>("CONTINUE",HttpStatus.CONTINUE);
            case 9:
                return new ResponseEntity<>("CREATED",HttpStatus.CREATED);
            case 10:
                return new ResponseEntity<>("OK",HttpStatus.OK);
            default:
                return new ResponseEntity<>("DEFAULT, Nothing",HttpStatus.OK);
        }
    }

}
