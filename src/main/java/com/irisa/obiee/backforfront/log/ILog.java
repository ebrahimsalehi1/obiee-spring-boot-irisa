package com.irisa.obiee.backforfront.log;

import com.irisa.obiee.backforfront.log.logstore.LogStore;

public interface ILog {
    public void writeData(LogStore logStore);
    public String readData(String key);
}
