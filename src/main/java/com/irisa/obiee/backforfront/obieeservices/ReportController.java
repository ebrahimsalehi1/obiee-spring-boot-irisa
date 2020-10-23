package com.irisa.obiee.backforfront.obieeservices;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.irisa.obiee.backforfront.general.GeneralService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/obiee-bff",produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

    @Autowired
    GeneralService generalService;

    @Autowired
    ReportService reportService;

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

        ResponseEntity res = generalService.callWebService(url, HttpMethod.POST,body,true);

        Report[] reports = new Gson().fromJson(res.getBody().toString(), Report[].class);

        return new ResponseEntity<>(new Gson().toJson(reportService.changeReports(Arrays.asList(reports))).toString(),HttpStatus.OK);

//        return new ResponseEntity<>(new JSONArray().put(new JSONObject()
//                .put("id",1)
//                .put("caption","ebrahim")
//                .put("description","Ebrahim Salehi")).toString(),HttpStatus.OK);

    }

    @PostMapping(value = "/reports/dashboard")
    public ResponseEntity<?> getReportListDashboard(@RequestBody String body) throws Exception{

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/assitanceandmydashboards";

//        return generalService.callWebService(url,HttpMethod.POST,body,true);

        ResponseEntity res = generalService.callWebService(url, HttpMethod.POST,body,true);

        Report[] reports = new Gson().fromJson(res.getBody().toString(), Report[].class);

        return new ResponseEntity<>(new Gson().toJson(reportService.changeReports(Arrays.asList(reports))).toString(),HttpStatus.OK);

    }

    @PostMapping(value = "/reports/analyser")
    public ResponseEntity<?> getReportListAnalyser(@RequestBody String body){

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/AnalyserProjects";

//        return generalService.callWebService(url,HttpMethod.POST,body,true);

        ResponseEntity res = generalService.callWebService(url, HttpMethod.POST,body,true);

        Report[] reports = new Gson().fromJson(res.getBody().toString(), Report[].class);

        return new ResponseEntity<>(new Gson().toJson(reportService.changeReports(Arrays.asList(reports))).toString(),HttpStatus.OK);

    }

}
