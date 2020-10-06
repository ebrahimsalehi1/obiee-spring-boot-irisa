package com.irisa.obiee.backforfront.general;

import org.springframework.http.HttpMethod;

import java.util.Map;

public interface GeneralService {

    public String callWebService(String url, HttpMethod httpMethod, Map<String,Object> inputParameters);
    public String callChashableService(String url,HttpMethod httpMethod,Map<String,Object> info);

}
