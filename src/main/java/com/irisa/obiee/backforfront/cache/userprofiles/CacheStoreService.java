package com.irisa.obiee.backforfront.cache.userprofiles;


import javax.persistence.EntityNotFoundException;

public interface CacheStoreService {
     int add(CacheStore userProfile);
     String getByKey(String key) throws EntityNotFoundException;
     int delete(CacheStore userProfile) throws EntityNotFoundException;
     int edit(CacheStore userProfile);
     boolean isExist(String key);
}
