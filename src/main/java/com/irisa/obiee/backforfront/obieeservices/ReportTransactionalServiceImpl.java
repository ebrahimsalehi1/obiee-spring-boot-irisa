package com.irisa.obiee.backforfront.obieeservices;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class ReportTransactionalServiceImpl implements ReportService {

    @Override
    public String getReportList(String userName,String searchWord) {

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/CatalogMng/Reports";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Map<String,String> inputParameters = new HashMap<>();
        inputParameters.put("user",userName);
        inputParameters.put("searchWord",searchWord);

        HttpEntity<?> httpEntity = new HttpEntity<>();
        return restTemplate.exchange(url, HttpMethod.POST,httpEntity,String.class).getBody();

    }

}
