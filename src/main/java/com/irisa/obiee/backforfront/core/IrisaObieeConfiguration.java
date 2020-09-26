package com.irisa.obiee.backforfront.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class IrisaObieeConfiguration {

    private static IrisaObieeConfiguration configuration = new IrisaObieeConfiguration();
    private Properties properties;

    private IrisaObieeConfiguration() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/webservice.properties");
            properties = new Properties();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static IrisaObieeConfiguration getInstance(){
        return configuration;
    }

    public static void print(){
        System.out.println();
    }

}

