package com.irisa.obiee.backforfront.log.logstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogStoreServiceImpl implements LogStoreService {

    @Autowired
    LogStoreRepository logStoreRepository;

    @Override
    public void writeData(LogStore logStore) {
        logStoreRepository.save(logStore);
    }

    @Override
    public List<LogStore> readData(String key) {
        return logStoreRepository.findByKey(key);
    }
}
