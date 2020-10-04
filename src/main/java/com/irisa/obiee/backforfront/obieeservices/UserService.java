package com.irisa.obiee.backforfront.obieeservices;

import org.json.JSONObject;

public interface UserService {
    public JSONObject getAll();
    public JSONObject getByCondition(String seearchKey);
}
