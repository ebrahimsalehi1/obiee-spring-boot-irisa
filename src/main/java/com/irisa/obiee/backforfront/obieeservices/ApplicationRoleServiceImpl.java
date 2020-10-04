package com.irisa.obiee.backforfront.obieeservices;

import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class ApplicationRoleServiceImpl implements ApplicationRoleService {
    @Override
    public boolean hasAdminRole(String userName) {
        String url = "http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/hasBIAdminRole/"+userName;
        RestTemplate restTemplate = new RestTemplate();
        Boolean result = restTemplate.getForObject(url,Boolean.class);
        return result.booleanValue();
    }

    @Override
    public boolean addRole(JSONObject role) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/obi" ;

        return false;
    }

    @Override
    public boolean editRole(JSONObject role) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/obi" ;

        return false;
    }

    @Override
    public boolean deleteRole(String roleName) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/obi/{rolname}" ;

        return false;
    }

    @Override
    public JSONObject getAll() {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/list/obi?detail=true" ;

        return null;
    }

    @Override
    public JSONObject getByCondition(JSONObject search) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/search/list/obi/{searchword}?deatil=true&owner=AN" ;

        return null;
    }

    @Override
    public boolean assignUserToRole(String roleName, String userName) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/assigeroletouser/obi/{rolename}/{username}" ;

        return false;
    }

    @Override
    public boolean deleteUserFromRole(String roleName, String userName) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/removerolefromuser/obi/{rolename}/{username}" ;

        return false;
    }

    @Override
    public JSONObject getListOfUsersRole(String roleName) {
        String url = " http://172.25.40.135:9500/OBISEC/api/v1.0/ApplicationRoleMng/usermembers/list/obi/{approle_name}?isDirect=true" ;

        return null;
    }
}
