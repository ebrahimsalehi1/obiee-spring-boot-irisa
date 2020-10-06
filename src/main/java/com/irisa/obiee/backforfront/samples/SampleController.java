package com.irisa.obiee.backforfront.samples;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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

    @RequestMapping(value="/sum", method=RequestMethod.POST)
    public int addition(@RequestBody Map<String, Integer> param) {
        int number1 = param.get("number1");
        int number2 = param.get("number2");
        return number1 + number2;
    }

//    @PostMapping(value="/approle/create",consumes = MediaType.APPLICATION_JSON_VALUE)
//    public
//    @ResponseBody
//    ResponseEntity<Boolean> addRole(@RequestBody Map<String,String> role, HttpServletRequest httpServletRequest, HttpServletResponse response){
//
////        System.out.println("name="+role.get("name"));
////        System.out.println("displayName="+role.get("displayName"));
////        System.out.println("description="+role.get("description"));
////        System.out.println("appId="+role.get("appId"));
////        System.out.println("type="+role.get("type"));
////        System.out.println("baseRoles="+role.get("baseRoles"));
//
//        System.out.println("number1="+role.get("number1"));
//        System.out.println("number2="+role.get("number2"));
//
//        return new ResponseEntity<>(true, HttpStatus.OK);
//
//        //return new ResponseEntity<>(applicationRole.addRole(role).booleanValue(), HttpStatus.OK);
//    }

}
