package com.irisa.obiee.backforfront.general;

import com.irisa.obiee.backforfront.cache.cachestore.CacheStore;
import com.irisa.obiee.backforfront.cache.cachestore.CacheStoreService;
import com.irisa.obiee.backforfront.log.logstore.LogStore;
import com.irisa.obiee.backforfront.log.logstore.LogStoreService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class GeneralServiceImpl implements GeneralService {

    @Value("${is-cashe-enable}")
    private boolean isCacheEnable;

    @Value("${is-log-enable}")
    private boolean isLogEnable;

    @Autowired
    CacheStoreService cacheStoreService;

    @Autowired
    LogStoreService logStoreService;

    private ResponseEntity<?> callWebServiceOnly(String url, HttpMethod httpMethod, String inputParameters) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> httpEntity = new HttpEntity<>(inputParameters,httpHeaders);

        ResponseEntity exchanResponseEntity=null;
        try {
            exchanResponseEntity =restTemplate.exchange(url, httpMethod,httpEntity,String.class);
        }
        catch (HttpStatusCodeException ex){

            return new ResponseEntity<>(ex.getMessage().substring(ex.getMessage().indexOf("["),ex.getMessage().length()),ex.getStatusCode());

        }

        return exchanResponseEntity;
    }


    public ResponseEntity<?> callWebService(String url,HttpMethod httpMethod,String info,boolean doCache) {

        String cashedValue = null;
        ResponseEntity webServiceResponseEntity = null;

        String keyToCacheOrLog = null;

        if(info != null) {
            JSONObject jsonObject = new JSONObject(info);
            keyToCacheOrLog = url + "@" + httpMethod.toString() + "@" + jsonObject.toString();
        }
        else
            keyToCacheOrLog = url + "@" + httpMethod.toString();


        if(doCache) {
            if (isCacheEnable) {

                if (cacheStoreService.isExist(keyToCacheOrLog))
                    webServiceResponseEntity = new ResponseEntity<>(cacheStoreService.getByKey(keyToCacheOrLog),HttpStatus.OK);
                else {
                    webServiceResponseEntity = callWebServiceOnly(url, httpMethod, info);
                    cacheStoreService.add(new CacheStore(keyToCacheOrLog, webServiceResponseEntity.getBody().toString()));
                }

            } else
                webServiceResponseEntity = callWebServiceOnly(url, httpMethod, info);

        }
        else
            webServiceResponseEntity = callWebServiceOnly(url, httpMethod, info);

        if(isLogEnable){
            logStoreService.writeData(new LogStore(new Date(),keyToCacheOrLog,webServiceResponseEntity.getBody().toString()));
        }

        return webServiceResponseEntity;
    }

}
