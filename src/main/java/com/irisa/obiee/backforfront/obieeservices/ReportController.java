package com.irisa.obiee.backforfront.obieeservices;

import org.springframework.beans.factory.annotation.Autowired;
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
    ReportService reportService;

    @PostMapping(value = "/reports/transactional",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getReportListTransactional(@RequestBody Map<String,String> map){

        String userName = map.get("user");
        String searchWord = map.get("searchWord");
        return new ResponseEntity<>(reportService.getReportListTransactional(userName,searchWord), HttpStatus.OK);
    }

    @PostMapping(value = "/reports/dashboard",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getReportListDashboard(@RequestBody Map<String,String> map){

        String userName = map.get("user");
        String searchWord = map.get("searchWord");
        return new ResponseEntity<>(reportService.getReportListDashboard(userName,searchWord), HttpStatus.OK);
    }

    @PostMapping(value = "/reports/analyser",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getReportListAnalyser(@RequestBody Map<String,String> map){

        String userName = map.get("user");
        String searchWord = map.get("searchWord");
        return new ResponseEntity<>(reportService.getReportListAnalyser(userName,searchWord), HttpStatus.OK);
    }

}
