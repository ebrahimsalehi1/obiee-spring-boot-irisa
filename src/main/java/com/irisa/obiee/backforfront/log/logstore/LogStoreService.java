package com.irisa.obiee.backforfront.log.logstore;

import java.util.List;

public interface LogStoreService {
    public void writeData(LogStore logStore);
    public List<LogStore> readData(String key);
}
