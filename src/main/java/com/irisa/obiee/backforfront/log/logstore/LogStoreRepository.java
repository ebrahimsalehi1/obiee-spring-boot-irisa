package com.irisa.obiee.backforfront.log.logstore;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogStoreRepository extends JpaRepository<LogStore, Long> {
    @Override
    LogStore save(LogStore s);
    List<LogStore> findByKey(String key);
}
