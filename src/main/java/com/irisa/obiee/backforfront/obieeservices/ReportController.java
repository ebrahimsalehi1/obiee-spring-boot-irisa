package com.irisa.obiee.backforfront.obieeservices;

import com.irisa.obiee.backforfront.general.GeneralService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/obiee-bff",produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

    @Autowired
    GeneralService generalService;

    @GetMapping(value = "/reports/sample")
    public ResponseEntity<?> getReportListSample(){

        return new ResponseEntity<>(new JSONObject().put("text","hello worlds!!!").toString(),HttpStatus.OK);
    }

    @PostMapping(value = "/reports/sample2")
    public ResponseEntity<?> getReportListSample2(@RequestBody String map){

        return new ResponseEntity<>(new JSONObject().put("result2","Hello Worlds !!!").toString(),HttpStatus.OK);
    }


    @PostMapping(value = "/reports/transactional")
    public ResponseEntity<?> getReportListTransactional(@RequestBody String body){

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/Reports";

        return generalService.callWebService(url, HttpMethod.POST,body,true);

    }

    @PostMapping(value = "/reports/dashboard")
    public ResponseEntity<?> getReportListDashboard(@RequestBody String body){

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/assitanceandmydashboards";

        return generalService.callWebService(url,HttpMethod.POST,body,true);

    }

    @PostMapping(value = "/reports/analyser")
    public ResponseEntity<?> getReportListAnalyser(@RequestBody String body){

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/AnalyserProjects";

        return generalService.callWebService(url,HttpMethod.POST,body,true);
    }

}
