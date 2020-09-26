package com.irisa.obiee.backforfront.cache;


public interface ICache {
     void set(String key,String value);
     String get(String key);
}
