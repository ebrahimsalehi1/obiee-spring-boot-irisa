package com.irisa.obiee.backforfront.obieeservices;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/obiee-bff")
public class ApplicationRoleController {

    @Autowired
    ApplicationRoleService applicationRoleService;

    @GetMapping(value="/approle/hasAdminRole/{userName}")
    public ResponseEntity<Boolean> hasAdminRole(@PathVariable String userName){
        return new ResponseEntity<>(applicationRoleService.hasAdminRole(userName), HttpStatus.OK);
    }

    @PostMapping(value="/approle/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseEntity<Boolean> addRole(@RequestBody Map<String,Object> role){
        return new ResponseEntity<>(applicationRoleService.addRole(role).booleanValue(), HttpStatus.OK);
    }

    @PutMapping(value="/approle/edit",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> editRole(@RequestBody Map<String,Object> role){
        return new ResponseEntity<>(applicationRoleService.editRole(role).booleanValue(), HttpStatus.OK);
    }

    @GetMapping(value="/approle/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAll(){
        return new ResponseEntity<>(applicationRoleService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value="/approle/search/{searchword}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getByCondition(@PathVariable String searchword){
        return new ResponseEntity<>(applicationRoleService.getByCondition(searchword), HttpStatus.OK);
    }

    @PutMapping(value="/approle/assignUserToRole/{roleName}/{userName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> assignUserToRole(@PathVariable String roleName,@PathVariable String userName){
        return new ResponseEntity<>(applicationRoleService.assignUserToRole(roleName,userName).booleanValue(), HttpStatus.OK);
    }

    @PutMapping(value="/approle/deleteUserFromRole/{roleName}/{userName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteUserFromRole(@PathVariable String roleName,@PathVariable String userName){
        return new ResponseEntity<>(applicationRoleService.deleteUserFromRole(roleName,userName).booleanValue(), HttpStatus.OK);
    }

    @GetMapping(value="/approle/listUsersOfRole/{roleName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getListOfUsersRole(@PathVariable String roleName){
        return new ResponseEntity<>(applicationRoleService.getListOfUsersRole(roleName), HttpStatus.OK);
    }


}
