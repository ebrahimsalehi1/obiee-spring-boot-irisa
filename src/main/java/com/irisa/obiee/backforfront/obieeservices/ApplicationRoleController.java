package com.irisa.obiee.backforfront.obieeservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/obiee-bff",consumes = MediaType.APPLICATION_JSON_VALUE)
public class ApplicationRoleController {

    ApplicationRoleServiceImpl applicationRole = new ApplicationRoleServiceImpl();

    @GetMapping(value="/hasAdminRole/{userName}")
    public ResponseEntity<Boolean> hasAdminRole(@PathVariable String userName){
        return new ResponseEntity<>(applicationRole.hasAdminRole(userName), HttpStatus.OK);
    }

    @PostMapping(value="/approle/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public
    ResponseEntity<Boolean> addRole(@RequestBody Map<String,String> role){
        String dtr="";
        return new ResponseEntity<>(applicationRole.addRole(role), HttpStatus.OK);
    }
}
