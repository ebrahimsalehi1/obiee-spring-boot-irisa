package com.irisa.obiee.backforfront.obieeservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/obiee-bff",consumes = MediaType.APPLICATION_JSON_VALUE)
public class ApplicationRoleController {

    ApplicationRoleImpl applicationRole = new ApplicationRoleImpl();

    @GetMapping(value="/hasAdminRole/{userName}")
    public ResponseEntity<Boolean> hasAdminRole(@PathVariable String userName){
        return new ResponseEntity<>(applicationRole.hasAdminRole(userName), HttpStatus.OK);
    }
}
