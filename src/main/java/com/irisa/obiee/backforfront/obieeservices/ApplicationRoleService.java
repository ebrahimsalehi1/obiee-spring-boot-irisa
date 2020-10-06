package com.irisa.obiee.backforfront.obieeservices;


import org.json.JSONObject;

import java.util.Map;

public interface ApplicationRoleService {
    public Boolean hasAdminRole(String userName);
    public Boolean addRole(Map<String,Object> role);
    public Boolean editRole(Map<String,Object> role);
    public Boolean deleteRole(String roleName);
    public String getAll();
    public String getByCondition(String searchword);
    public Boolean assignUserToRole(String roleName,String userName);
    public Boolean deleteUserFromRole(String roleName,String userName);
    public String getListOfUsersRole(String roleName);
}
