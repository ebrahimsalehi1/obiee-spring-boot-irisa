package com.irisa.obiee.backforfront.cache;

import com.irisa.obiee.backforfront.cache.cachestore.CacheStore;
import com.irisa.obiee.backforfront.cache.cachestore.CacheStoreService;
import org.springframework.beans.factory.annotation.Autowired;

public class OracleCacheMethod implements ICache {

    @Autowired
    CacheStoreService cacheStoreService;

    @Override
    public void set(String key, String value) {
        boolean isexist = cacheStoreService.isExist(key);

        if(isexist)
            cacheStoreService.edit(new CacheStore(key,value));
        else
            cacheStoreService.add(new CacheStore(key,value));
    }

    @Override
    public String get(String key) {
        String result = cacheStoreService.getByKey(key);
        return result;
    }
}
