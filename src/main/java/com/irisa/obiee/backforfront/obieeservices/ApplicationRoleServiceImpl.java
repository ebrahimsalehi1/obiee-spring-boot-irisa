package com.irisa.obiee.backforfront.obieeservices;

import com.irisa.obiee.backforfront.general.GeneralService;
import com.irisa.obiee.backforfront.general.GeneralServiceImpl;
import org.json.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApplicationRoleServiceImpl implements ApplicationRoleService {

    //@Autowired
    GeneralService generalService=new GeneralServiceImpl();

    @Override
    public Boolean hasAdminRole(String userName) {
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/hasBIAdminRole/"+userName;
        return Boolean.valueOf(generalService.callWebService(url,HttpMethod.GET,null));
    }

    @Override
    public Boolean addRole(Map<String,String> role) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/obi" ;

        return Boolean.valueOf(generalService.callWebService(url,HttpMethod.POST,role));

    }

    @Override
    public Boolean editRole(JSONObject role) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/obi" ;

        return false;
    }

    @Override
    public Boolean deleteRole(String roleName) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/obi/{rolname}" ;

        return false;
    }

    @Override
    public String getAll() {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/list/obi?detail=true" ;

        return null;
    }

    @Override
    public String getByCondition(JSONObject search) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/search/list/obi/{searchword}?deatil=true&owner=AN" ;

        return null;
    }

    @Override
    public Boolean assignUserToRole(String roleName, String userName) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/assigeroletouser/obi/{rolename}/{username}" ;

        return false;
    }

    @Override
    public Boolean deleteUserFromRole(String roleName, String userName) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/removerolefromuser/obi/{rolename}/{username}" ;

        return false;
    }

    @Override
    public String getListOfUsersRole(String roleName) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/usermembers/list/obi/{approle_name}?isDirect=true" ;

        return null;
    }
}
