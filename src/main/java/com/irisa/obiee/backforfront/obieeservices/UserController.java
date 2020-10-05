package com.irisa.obiee.backforfront.obieeservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/obiee-bff",consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired UserService userService;

    //public String getAll();
    //public String getByCondition(String seearchKey);

    @GetMapping(value="/allUsers")
    public ResponseEntity<String> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }


    @GetMapping(value="/serachUsers/{searchCondition}")
    public ResponseEntity<String> getByCondition(@PathVariable String searchCondition){
        return new ResponseEntity<>(userService.getByCondition(searchCondition), HttpStatus.OK);
    }

}
