package com.irisa.obiee.backforfront.cache.userprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CacheStoreImpl implements CacheStoreService {

    @Autowired
    CacheStoreRepository userProfileRepository;

    @Override
    public String getByKey(String key) throws EntityNotFoundException {
        CacheStore userProfile = userProfileRepository.getOne(key);
        return userProfile.getValue();
    }

    @Override
    public int add(CacheStore userProfile) {
        userProfileRepository.save(userProfile);
        return 1;
    }

    @Override
    public int delete(CacheStore userProfile) throws EntityNotFoundException {
        userProfileRepository.delete(userProfile);
        return 1;
    }

    @Override
    public int edit(CacheStore userProfile) {
        userProfileRepository.save(userProfile);
        return 1;
    }

    @Override
    public boolean isExist(String key) {
        return userProfileRepository.existsById(key);
    }

}
