package com.irisa.obiee.backforfront.obieeservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/obiee-bff")
public class LoginController {

    @Autowired
    LoginService login;

    @PostMapping(value="/login")
    public ResponseEntity<String> login(){
        return new ResponseEntity<>(login.logInByWeblogicAdmin(), HttpStatus.OK);
    }

    @PostMapping(value="/login/{userName}")
    public ResponseEntity<String> loginBehalf(@PathVariable String userName){
        return new ResponseEntity<>(login.logInBehalf(userName), HttpStatus.OK);
    }

}

