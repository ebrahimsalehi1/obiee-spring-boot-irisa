package com.irisa.obiee.backforfront.general;

import com.irisa.obiee.backforfront.cache.cachestore.CacheStore;
import com.irisa.obiee.backforfront.cache.cachestore.CacheStoreService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GeneralServiceImpl implements GeneralService {

    @Value("${is-cashe-enable}")
    private boolean isCacheEnable;

    @Autowired
    CacheStoreService cacheStoreService;

//    public Boolean callWebServiceGetBoolean(String url,Map<String,String> inputParameters) {
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject(url, Boolean.class);
//
//    }


    public String callWebService(String url, HttpMethod httpMethod, Map<String,Object> inputParameters) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> httpEntity = new HttpEntity<>(inputParameters,httpHeaders);
        return restTemplate.exchange(url, httpMethod,httpEntity,String.class).getBody();
    }

    public String callChashableService(String url,HttpMethod httpMethod,Map<String,Object> info) {
        String result = null;

        JSONObject jsonObject = new JSONObject(info);
        String keyToCache = url+"@"+httpMethod.toString()+"@"+jsonObject.toString();

        if(isCacheEnable){

            if(cacheStoreService.isExist(keyToCache))
                result = cacheStoreService.getByKey(keyToCache);
            else{
                result = callWebService(url,httpMethod,info);
                cacheStoreService.add(new CacheStore(keyToCache,result));
            }

        }
        else{
            result = callWebService(url,httpMethod,info);
        }

        return result;
    }

}
