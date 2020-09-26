package com.irisa.obiee.backforfront.obieeservices;

import org.springframework.stereotype.Service;

public interface LoginService {
    public String logInByWeblogicAdmin();
    public String logInBehalf(String userName);
    public boolean logOff(String userName);
}
