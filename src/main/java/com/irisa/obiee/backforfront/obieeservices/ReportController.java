package com.irisa.obiee.backforfront.obieeservices;

import com.irisa.obiee.backforfront.general.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/obiee-bff")
public class ReportController {

    @Autowired
    GeneralService generalService;

    @PostMapping(value = "/reports/transactional",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getReportListTransactional(@RequestBody Map<String,Object> map){

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/Reports";

        return generalService.callWebService(url, HttpMethod.POST,map,true);
    }

    @PostMapping(value = "/reports/dashboard",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getReportListDashboard(@RequestBody Map<String,Object> map){

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/assitanceandmydashboards";

        return generalService.callWebService(url,HttpMethod.POST,map,true);

    }

    @PostMapping(value = "/reports/analyser",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getReportListAnalyser(@RequestBody Map<String,Object> map){

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/AnalyserProjects";

        return generalService.callWebService(url,HttpMethod.POST,map,true);
    }

}
