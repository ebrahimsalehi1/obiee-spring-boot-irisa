package com.irisa.obiee.backforfront.obieeservices;

import com.irisa.obiee.backforfront.general.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/obiee-bff")
public class LoginController {

    @Autowired
    GeneralService generalService;

    @PostMapping(value="/login")
    public ResponseEntity<?> login(@RequestBody String body){

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/SawSession/LogOn/";
//        String body = "{\n" +
//                "    \"userName\":\"weblogic\",\n" +
//                "    \"password\":\"APEXadmin1234\"\n" +
//                "}";

        return generalService.callWebService(url, HttpMethod.POST,body,false);
    }

    @PostMapping(value="/loginOnBehalf")
    public ResponseEntity<?> loginBehalf(@RequestBody String body){

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/SawSession/LogOnBehalf";

        return generalService.callWebService(url,HttpMethod.POST,body,false);
    }

}

