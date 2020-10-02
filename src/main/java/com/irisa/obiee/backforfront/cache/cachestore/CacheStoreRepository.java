package com.irisa.obiee.backforfront.cache.cachestore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface CacheStoreRepository extends JpaRepository<CacheStore,String>,CrudRepository<CacheStore,String> {

    @Override
    CacheStore getOne(String s);

    @Override
    boolean existsById(String s);

    @Override
    CacheStore save(CacheStore s);

    @Override
    void delete(CacheStore userProfile);



}
