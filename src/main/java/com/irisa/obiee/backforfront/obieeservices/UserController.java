package com.irisa.obiee.backforfront.obieeservices;

import com.irisa.obiee.backforfront.general.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/obiee-bff",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    GeneralService generalService;

    @GetMapping(value="/userMng/allUsers")
    public ResponseEntity<?> getAll(){

        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/UserMng/AllUsers?detail=true" ;

        return generalService.callWebService(url, HttpMethod.GET,null,true);
    }


    @GetMapping(value="/userMng/serachUsers/{searchCondition}")
    public ResponseEntity<?> getByCondition(@PathVariable String searchCondition){

        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/UserMng/Search/{searchkey}?detail=true" ;

        return generalService.callWebService(url,HttpMethod.GET,null,true);
    }

    @GetMapping(value="/userMng/{userName}")
    public ResponseEntity<?> getUserInfo(@PathVariable String userName){

        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/UserMng/"+userName ;

        return generalService.callWebService(url,HttpMethod.GET,null,true);
    }

}
