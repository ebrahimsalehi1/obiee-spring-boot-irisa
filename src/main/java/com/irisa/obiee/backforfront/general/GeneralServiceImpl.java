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

    @Value("${preUrl}")
    private String preUrl;

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
        String mainUrl = preUrl+url;

        String keyToCacheOrLog = null;

        try {
            if (info != null) {
                JSONObject jsonObject = new JSONObject(info);
                keyToCacheOrLog = mainUrl + "@" + httpMethod.toString() + "@" + jsonObject.toString();
            } else
                keyToCacheOrLog = mainUrl + "@" + httpMethod.toString();


            if (doCache) {
                if (isCacheEnable) {

                    if (cacheStoreService.isExist(keyToCacheOrLog))
                        webServiceResponseEntity = new ResponseEntity<>(cacheStoreService.getByKey(keyToCacheOrLog), HttpStatus.OK);
                    else {
                        webServiceResponseEntity = callWebServiceOnly(mainUrl, httpMethod, info);
                        if (webServiceResponseEntity.getStatusCodeValue() == 200)
                            cacheStoreService.add(new CacheStore(keyToCacheOrLog, webServiceResponseEntity.getBody().toString()));
                    }

                } else
                    webServiceResponseEntity = callWebServiceOnly(mainUrl, httpMethod, info);

            } else
                webServiceResponseEntity = callWebServiceOnly(mainUrl, httpMethod, info);

            if (isLogEnable) {
                logStoreService.writeData(new LogStore(new Date(), keyToCacheOrLog, webServiceResponseEntity.getBody() != null ? webServiceResponseEntity.getBody().toString() : "null"));
            }
        }
        catch(Exception ex){
            webServiceResponseEntity = new ResponseEntity<>(
                    new JSONObject()
                            .put("errorPersian","")
                            .put("errorLatin","")
                            .put("errorMessage",ex.getMessage()).toString()
                    ,HttpStatus.EXPECTATION_FAILED);
        }

        return webServiceResponseEntity;
    }

}
