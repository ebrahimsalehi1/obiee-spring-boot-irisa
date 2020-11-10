package com.irisa.obiee.backforfront.obieeservices;

import com.irisa.obiee.backforfront.general.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/obiee-bff/catalog",produces = MediaType.APPLICATION_JSON_VALUE)
public class CatalogController {

    @Autowired
    GeneralService generalService;

    @PostMapping(value="/tree")
    public ResponseEntity<?> tree(@RequestBody String body) throws Exception{

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/tree";

        ResponseEntity res = generalService.callWebService(url, HttpMethod.POST,body,true);
        return res;
    }

}
