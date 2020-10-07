package com.irisa.obiee.backforfront.obieeservices;

import com.irisa.obiee.backforfront.general.GeneralService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
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
    GeneralService generalService;

    @GetMapping(value="/approle/hasAdminRole/{userName}")
    public ResponseEntity<?> hasAdminRole(@PathVariable String userName){
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/hasBIAdminRole/"+userName;
        return generalService.callWebService(url, HttpMethod.GET,null,false);
    }

    @PostMapping(value="/approle/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseEntity<?> addRole(@RequestBody Map<String,Object> role){
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/obi" ;

        return generalService.callWebService(url,HttpMethod.POST,role,false);
    }

    @PutMapping(value="/approle/edit",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editRole(@RequestBody Map<String,Object> role){
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/obi" ;

        return generalService.callWebService(url,HttpMethod.PUT,role,false);
    }

    @DeleteMapping(value="/approle/delete/{roleName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteRole(@PathVariable String roleName){
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/obi/"+roleName ;

        return generalService.callWebService(url,HttpMethod.DELETE,null,false);
    }

    @GetMapping(value="/approle/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/list/obi?detail=true" ;

        return generalService.callWebService(url,HttpMethod.GET,null,true);
    }

    @GetMapping(value="/approle/search/{searchword}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByCondition(@PathVariable String searchword){
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/search/list/obi/"+searchword+"?deatil=true&owner=AN" ;

        return generalService.callWebService(url,HttpMethod.GET,null,true);    }

    @PutMapping(value="/approle/assignUserToRole/{roleName}/{userName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> assignUserToRole(@PathVariable String roleName,@PathVariable String userName){
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/assigeroletouser/obi/"+roleName+"/"+userName ;

        return generalService.callWebService(url,HttpMethod.PUT,null,false);
    }

    @PutMapping(value="/approle/deleteUserFromRole/{roleName}/{userName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUserFromRole(@PathVariable String roleName,@PathVariable String userName){

        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/removerolefromuser/obi/"+roleName+"/"+userName ;

        return generalService.callWebService(url,HttpMethod.PUT,null,false);
    }

    @GetMapping(value="/approle/listUsersOfRole/{roleName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getListOfUsersRole(@PathVariable String roleName){
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/usermembers/list/obi/"+roleName+"?isDirect=true" ;

        return generalService.callWebService(url,HttpMethod.GET,null,false);
    }


}
