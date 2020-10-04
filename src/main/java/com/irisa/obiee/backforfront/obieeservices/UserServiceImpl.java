package com.irisa.obiee.backforfront.obieeservices;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public JSONObject getAll() {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/UserMng/AllUsers?detail=true" ;

        return null;
    }

    @Override
    public JSONObject getByCondition(String seearchKey) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/UserMng/Search/{searchkey}?detail=true" ;

        return null;
    }
}
