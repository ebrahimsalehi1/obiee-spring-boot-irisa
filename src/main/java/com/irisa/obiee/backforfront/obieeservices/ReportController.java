package com.irisa.obiee.backforfront.obieeservices;

import com.irisa.obiee.backforfront.general.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping(value = "/obiee-bff")
public class ReportController {

    @Autowired
    GeneralService generalService;

    @PostMapping(value = "/reports/sample",consumes = MediaType.ALL_VALUE)
    public ResponseEntity<?> getReportListSample(@RequestBody Map<String,Object> map){


        return new ResponseEntity<>("Hello",HttpStatus.OK);
    }


    @PostMapping(value = "/reports/transactional")
    public ResponseEntity<?> getReportListTransactional(@RequestBody String body){

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/Reports";

        return generalService.callWebService(url, HttpMethod.POST,body,true);

    }

    @PostMapping(value = "/reports/dashboard",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getReportListDashboard(@RequestBody String body){

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/assitanceandmydashboards";

        return generalService.callWebService(url,HttpMethod.POST,body,true);

    }

    @PostMapping(value = "/reports/analyser",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getReportListAnalyser(@RequestBody String body){

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/AnalyserProjects";

        return generalService.callWebService(url,HttpMethod.POST,body,true);
    }

}
