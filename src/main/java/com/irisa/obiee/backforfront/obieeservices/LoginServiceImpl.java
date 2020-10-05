package com.irisa.obiee.backforfront.obieeservices;

import com.irisa.obiee.backforfront.general.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    GeneralService generalService;

    @Override
    public String logInByWeblogicAdmin() {
        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/SawSession/LogOn/";

        Map<String,String> inputParameters = new HashMap<>();
        inputParameters.put("userName","weblogic");
        inputParameters.put("password","APEXadmin1234");

        return generalService.callWebService(url,HttpMethod.POST,inputParameters);
    }

    @Override
    public String logInBehalf(String userName) {

        String url = "http://172.25.40.135:9500/OBISRV/api/v1.0/SawSession/LogOnBehalf";

        Map<String,String> inputParameters = new HashMap<>();
        inputParameters.put("userName",userName);
        inputParameters.put("adminPassword","APEXadmin1234");
        inputParameters.put("adminUserName","weblogic");

        return generalService.callWebService(url,HttpMethod.POST,inputParameters);

    }

    @Override
    public boolean logOff(String userName) {
        return false;
    }

}
