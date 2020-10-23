package com.irisa.obiee.backforfront.obieeservices;

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
@Transactional(timeout = 5)
public class UserController {

    @Autowired
    GeneralService generalService;

    @GetMapping(value="/user/all")
    public ResponseEntity<?> getAll() throws Exception{

        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/UserMng/AllUsers?detail=true" ;

        return generalService.callWebService(url, HttpMethod.GET,null,true);
    }

    @GetMapping(value="/user/serach/{searchCondition}")
    public ResponseEntity<?> getByCondition(@PathVariable String searchCondition){

        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/UserMng/Search/"+searchCondition+"?detail=true" ;

        return generalService.callWebService(url,HttpMethod.GET,null,true);
    }

    @GetMapping(value="/user/info/{userName}")
    public ResponseEntity<?> getUserInfo(@PathVariable String userName){

        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/UserMng/"+userName ;

        return generalService.callWebService(url,HttpMethod.GET,null,true);

    }

}
