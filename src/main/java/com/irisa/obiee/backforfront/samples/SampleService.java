package com.irisa.obiee.backforfront.samples;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public String getType(String item){
        return item;
    }
}
