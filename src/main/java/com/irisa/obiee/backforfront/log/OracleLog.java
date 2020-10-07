package com.irisa.obiee.backforfront.log;

import com.irisa.obiee.backforfront.log.logstore.LogStore;
import com.irisa.obiee.backforfront.log.logstore.LogStoreRepository;
import com.irisa.obiee.backforfront.log.logstore.LogStoreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OracleLog implements ILog {

    @Autowired
    LogStoreService logStoreService;

    @Override
    public void writeData(LogStore logStore) {
        logStoreService.writeData(logStore);
    }

    @Override
    public String readData(String key) {

        List<LogStore> stringList = logStoreService.readData(key);
        if(stringList.isEmpty())
            return null;
        else
            return stringList.get(0).getVal();
    }
}
