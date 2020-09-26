package com.irisa.obiee.backforfront.obieeservices;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public String logInByWeblogicAdmin() {
        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/SawSession/LogOn/";

        RestTemplate restTemplate = new RestTemplate();

        Map<String,String> inputParameters = new HashMap<>();
        inputParameters.put("userName","weblogic");
        inputParameters.put("password","APEXadmin1234");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> httpEntity = new HttpEntity<>(inputParameters,headers);

        return restTemplate.exchange(url, HttpMethod.POST,httpEntity,String.class).getBody();
    }

    @Override
    public String logInBehalf(String userName) {
        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/SawSession/LogOnBehalf";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Map<String,String> inputParameters = new HashMap<>();
        inputParameters.put("userName",userName);
        inputParameters.put("adminPassword","APEXadmin1234");
        inputParameters.put("adminUserName","weblogic");

        HttpEntity httpEntity = new HttpEntity(inputParameters,httpHeaders);

        return restTemplate.exchange(url,HttpMethod.POST,httpEntity,String.class).getBody();
    }

    @Override
    public boolean logOff(String userName) {
        return false;
    }

}
