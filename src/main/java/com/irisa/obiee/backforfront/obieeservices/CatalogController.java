package com.irisa.obiee.backforfront.obieeservices;

import com.irisa.obiee.backforfront.general.GeneralService;
import org.json.JSONObject;
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

    @PostMapping(value="/itemPermission")
    public ResponseEntity<?> itemPermission(@RequestBody String body) throws Exception{

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/itemPermission";

        ResponseEntity res = generalService.callWebService(url, HttpMethod.POST,body,true);
        return res;
    }

    @PutMapping(value="/addModifyPermission")
    public ResponseEntity<?> addModifyPermission(@RequestBody String body) throws Exception{

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/addModifyPermission";

        ResponseEntity res = generalService.callWebService(url, HttpMethod.PUT,body,true);
        return res;
    }

    @PutMapping(value="/addOpenPermission")
    public ResponseEntity<?> addOpenPermission(@RequestBody String body) throws Exception{

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/addOpenPermission";

        ResponseEntity res = generalService.callWebService(url, HttpMethod.PUT,body,true);
        return res;
    }

    @PutMapping(value="/addRunReportPermission")
    public ResponseEntity<?> addRunReportPermission(@RequestBody String body) throws Exception{

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/addRunReportPermission";

        ResponseEntity res = generalService.callWebService(url, HttpMethod.PUT,body,true);
        return res;
    }

    @PutMapping(value="/addFullPermission")
    public ResponseEntity<?> addFullPermission(@RequestBody String body) throws Exception{

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/addFullPermission";

        ResponseEntity res = generalService.callWebService(url, HttpMethod.PUT,body,true);
        return res;
    }

    @PutMapping(value="/addViewReportOutputPermission")
    public ResponseEntity<?> addViewReportOutputPermission(@RequestBody String body) throws Exception{

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/addViewReportOutputPermission";

        ResponseEntity res = generalService.callWebService(url, HttpMethod.PUT,body,true);
        return res;
    }

    @PutMapping(value="/addNoAccessPermission")
    public ResponseEntity<?> addNoAccessPermission(@RequestBody String body) throws Exception{

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/addNoAccessPermission";

        ResponseEntity res = generalService.callWebService(url, HttpMethod.PUT,body,true);
        return res;
    }

    @PutMapping(value="/addScheduleReportPermission")
    public ResponseEntity<?> addScheduleReportPermission(@RequestBody String body) throws Exception{

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/addScheduleReportPermission";

        ResponseEntity res = generalService.callWebService(url, HttpMethod.PUT,body,true);
        return res;
    }

    @PutMapping(value="/addCustomPermission")
    public ResponseEntity<?> addCustomPermission(@RequestBody String body) throws Exception{

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/addPermission";

        ResponseEntity res = generalService.callWebService(url, HttpMethod.PUT,body,true);
        return res;
    }

}
