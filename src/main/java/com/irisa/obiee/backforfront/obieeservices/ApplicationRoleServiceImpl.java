package com.irisa.obiee.backforfront.obieeservices;

import com.irisa.obiee.backforfront.general.GeneralService;
import com.irisa.obiee.backforfront.general.GeneralServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApplicationRoleServiceImpl implements ApplicationRoleService {

    @Autowired
    GeneralService generalService;

    @Override
    public Boolean hasAdminRole(String userName) {
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/hasBIAdminRole/"+userName;
        return Boolean.valueOf(generalService.callWebService(url,HttpMethod.GET,null));

    }

    @Override
    public Boolean addRole(Map<String,Object> role) {
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/obi" ;

        return Boolean.valueOf(generalService.callWebService(url,HttpMethod.POST,role));
    }

    @Override
    public Boolean editRole(Map<String,Object> role) {
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/obi" ;

        return Boolean.valueOf(generalService.callWebService(url,HttpMethod.PUT,role));
    }

    @Override
    public Boolean deleteRole(String roleName) {
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/obi/"+roleName ;

        return Boolean.valueOf(generalService.callWebService(url,HttpMethod.DELETE,null));
    }

    @Override
    public String getAll() {
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/list/obi?detail=true" ;

        return generalService.callChashableService(url,HttpMethod.GET,null);

    }

    @Override
    public String getByCondition(String searchword) {
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/search/list/obi/"+searchword+"?deatil=true&owner=AN" ;

        return generalService.callChashableService(url,HttpMethod.GET,null);
    }

    @Override
    public Boolean assignUserToRole(String roleName, String userName) {
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/assigeroletouser/obi/"+roleName+"/"+userName ;

        return Boolean.valueOf(generalService.callWebService(url,HttpMethod.PUT,null));

    }

    @Override
    public Boolean deleteUserFromRole(String roleName, String userName) {
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/removerolefromuser/obi/"+roleName+"/"+userName ;
        return Boolean.valueOf(generalService.callWebService(url,HttpMethod.PUT,null));
    }

    @Override
    public String getListOfUsersRole(String roleName) {
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/usermembers/list/obi/"+roleName+"?isDirect=true" ;

        return generalService.callChashableService(url,HttpMethod.GET,null);
    }
}
