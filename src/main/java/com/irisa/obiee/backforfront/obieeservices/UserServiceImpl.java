package com.irisa.obiee.backforfront.obieeservices;

import com.irisa.obiee.backforfront.cache.cachestore.CacheStore;
import com.irisa.obiee.backforfront.cache.cachestore.CacheStoreService;
import com.irisa.obiee.backforfront.general.GeneralService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    GeneralService generalService;

    @Override
    public String getAll() {

        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/UserMng/AllUsers?detail=true" ;
        return generalService.callChashableService(url,null);

    }

    @Override
    public String getByCondition(String searchKey) {

        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/UserMng/Search/{searchkey}?detail=true" ;
        return generalService.callChashableService(url,null);

    }
}
