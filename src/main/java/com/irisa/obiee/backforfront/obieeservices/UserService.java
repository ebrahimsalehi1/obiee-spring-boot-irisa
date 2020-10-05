package com.irisa.obiee.backforfront.obieeservices;

import org.json.JSONObject;

public interface UserService {
    public String getAll();
    public String getByCondition(String searchKey);
}
