package com.irisa.obiee.backforfront.obieeservices;

import com.google.gson.Gson;
import com.irisa.obiee.backforfront.general.GeneralService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/obiee-bff",produces = MediaType.APPLICATION_JSON_VALUE)
//@Transactional(timeout = 5)
public class UserController {

    @Autowired
    GeneralService generalService;

    @GetMapping(value="/user/all")
    public ResponseEntity<?> getAll() throws Exception{

        String url = "/OBISEC/api/v1.0/UserMng/AllUsers" ;//?detail=true

        ResponseEntity<?> res = generalService.callWebService(url, HttpMethod.GET,null,true);
        User[] users = new Gson().fromJson(res.getBody().toString(), User[].class);
        return new ResponseEntity<>(new Gson().toJson(users).toString(),HttpStatus.OK);

        //return generalService.callWebService(url, HttpMethod.GET,null,true);
    }

    @GetMapping(value="/user/serach/{searchCondition}")
    public ResponseEntity<?> getByCondition(@PathVariable String searchCondition){

        String url = "/OBISEC/api/v1.0/UserMng/Search/"+searchCondition+"?detail=true" ;

        return generalService.callWebService(url,HttpMethod.GET,null,true);
    }

    @GetMapping(value="/user/info/{userName}")
    public ResponseEntity<?> getUserInfo(@PathVariable String userName){

        String url = "/OBISEC/api/v1.0/UserMng/"+userName ;

        return generalService.callWebService(url,HttpMethod.GET,null,true);

    }

    @GetMapping(value="/user/usersofgroup/{groupName}")
    public ResponseEntity<?> getAllUsersMemberOfGroup(@PathVariable String groupName){

        String url = "/OBISEC/api/v1.0/UserMng/AllUsersMemberOfGroup/"+groupName ;

        return generalService.callWebService(url,HttpMethod.GET,null,true);

    }

}
