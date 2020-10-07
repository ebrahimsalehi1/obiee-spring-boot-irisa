package com.irisa.obiee.backforfront.general;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface GeneralService {
    public ResponseEntity<?> callWebService(String url, HttpMethod httpMethod, Map<String,Object> info, boolean doCache);
}
