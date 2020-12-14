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
@CrossOrigin
@RequestMapping(value = "/obiee-bff")
public class ApplicationRoleController {


    @Autowired
    GeneralService generalService;

    @GetMapping(value="/approle/hasAdminRole/{userName}")
    public ResponseEntity<?> hasAdminRole(@PathVariable String userName){
        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/hasBIAdminRole/"+userName;
        return generalService.callWebService(url, HttpMethod.GET,null,false);
    }

    @PostMapping(value="/approle/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseEntity<?> addRole(@RequestBody String role){
        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/obi" ;

        return generalService.callWebService(url,HttpMethod.POST,role,false);
    }

    @PutMapping(value="/approle/edit",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editRole(@RequestBody String role){
        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/obi" ;

        return generalService.callWebService(url,HttpMethod.PUT,role,false);
    }

    @DeleteMapping(value="/approle/delete/{roleName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteRole(@PathVariable String roleName){
        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/obi/"+roleName ;

        return generalService.callWebService(url,HttpMethod.DELETE,null,false);
    }

    @GetMapping(value="/approle/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){
        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/list/obi" ; // ?detail=true

        return generalService.callWebService(url,HttpMethod.GET,null,true);
    }

    @GetMapping(value="/approle/search/{searchword}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByCondition(@PathVariable String searchword){
        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/search/list/obi/"+searchword+"?owner=AN" ; //deatil=true&

        return generalService.callWebService(url,HttpMethod.GET,null,true);
    }

    @PutMapping(value="/approle/assignUserToRole/{roleName}/{userName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> assignUserToRole(@PathVariable String roleName,@PathVariable String userName){
        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/assignroletouser/obi/"+roleName+"/"+userName ;

        return generalService.callWebService(url,HttpMethod.PUT,null,false);
    }

    @PutMapping(value="/approle/deleteUserFromRole/{roleName}/{userName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUserFromRole(@PathVariable String roleName,@PathVariable String userName){

        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/removerolefromuser/obi/"+roleName+"/"+userName ;

        return generalService.callWebService(url,HttpMethod.PUT,null,false);
    }

    @GetMapping(value="/approle/listUsersOfRole/{roleName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getListOfUsersRole(@PathVariable String roleName){
        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/usermembers/list/obi/"+roleName;//+"?isDirect=true" ;

        return generalService.callWebService(url,HttpMethod.GET,null,false);
    }

    @PutMapping(value="/approle/assignroletorole/{parenroleName}/{childRoleName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> assigeRoleToRole(@PathVariable String parenroleName,@PathVariable String childRoleName){

        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/assignroletorole/obi/"+parenroleName+"/"+childRoleName ;

        return generalService.callWebService(url,HttpMethod.PUT,null,false);
    }

    @PutMapping(value="/approle/removerolefromrole/{parenroleName}/{childRoleName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> removeRoleFromRole(@PathVariable String parenroleName,@PathVariable String childRoleName){

        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/removerolefromrole/obi/"+parenroleName+"/"+childRoleName ;

        return generalService.callWebService(url,HttpMethod.PUT,null,false);
    }

    @PutMapping(value="/approle/assignroletogroup",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> assignRoleToGroup(@RequestBody String body){

        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/assignroletogroup";

        return generalService.callWebService(url,HttpMethod.PUT,body,false);
    }

    @PutMapping(value="/approle/removerolefromgroup",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> RemoveRoleFromGroup(@RequestBody String body){

        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/removerolefromgroup";

        return generalService.callWebService(url,HttpMethod.PUT,body,false);
    }

    @GetMapping(value="/approle/groupmembers/{roleName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> groupMembers(@PathVariable String roleName){
        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/groupmembers/list/obi/"+roleName;

        return generalService.callWebService(url,HttpMethod.GET,null,true);
    }

    @GetMapping(value="/approle/rolemembers/{roleName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> roleMembers(@PathVariable String roleName){
        String url = "/OBISEC/api/v1.0/ApplicationRoleMng/rolemembers/list/obi/"+roleName;

        return generalService.callWebService(url,HttpMethod.GET,null,true);
    }

}
