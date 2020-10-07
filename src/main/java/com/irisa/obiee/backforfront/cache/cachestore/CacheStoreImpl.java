package com.irisa.obiee.backforfront.cache.cachestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CacheStoreImpl implements CacheStoreService {

    @Autowired
    CacheStoreRepository cacheStoreRepository;

    @Override
    public String getByKey(String key) throws EntityNotFoundException {
        CacheStore cacheStore = cacheStoreRepository.getOne(key);
        return cacheStore.getValue();
    }

    @Override
    public int add(CacheStore cacheStore) {
        cacheStoreRepository.save(cacheStore);
        return 1;
    }

    @Override
    public int delete(CacheStore cacheStore) throws EntityNotFoundException {
        cacheStoreRepository.delete(cacheStore);
        return 1;
    }

    @Override
    public int edit(CacheStore cacheStore) {
        cacheStoreRepository.save(cacheStore);
        return 1;
    }

    @Override
    public boolean isExist(String key) {
        return cacheStoreRepository.existsById(key);
    }

}
