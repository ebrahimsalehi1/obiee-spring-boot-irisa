package com.irisa.obiee.backforfront.obieeservices;

import org.springframework.web.client.RestTemplate;

public class ApplicationRoleServiceImpl implements ApplicationRoleService {
    @Override
    public boolean hasAdminRole(String userName) {
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/hasBIAdminRole/"+userName;
        RestTemplate restTemplate = new RestTemplate();
        Boolean result = restTemplate.getForObject(url,Boolean.class);
        return result.booleanValue();
    }
}
