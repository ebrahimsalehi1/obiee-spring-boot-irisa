package com.irisa.obiee.backforfront.general;

import com.irisa.obiee.backforfront.cache.cachestore.CacheStore;
import com.irisa.obiee.backforfront.cache.cachestore.CacheStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public String callWebService(String url, HttpMethod httpMethod, Map<String,String> inputParameters) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> httpEntity = new HttpEntity<>(inputParameters,httpHeaders);
        return restTemplate.exchange(url, httpMethod,httpEntity,String.class).getBody();
    }

    public String callChashableService(String url,Map<String,String> info) {
        String result = null;

        if(isCacheEnable){

            if(cacheStoreService.isExist(url))
                result = cacheStoreService.getByKey(url);
            else{
                result = callWebService(url,HttpMethod.GET,info);
                cacheStoreService.add(new CacheStore(url,result));
            }

        }
        else{
            result = callWebService(url,HttpMethod.GET,info);
        }

        return result;
    }

}
