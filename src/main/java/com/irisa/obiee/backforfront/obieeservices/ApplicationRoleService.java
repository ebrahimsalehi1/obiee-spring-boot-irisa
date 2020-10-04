package com.irisa.obiee.backforfront.obieeservices;


import org.json.JSONObject;

public interface ApplicationRoleService {
    public boolean hasAdminRole(String userName);
    public boolean addRole(JSONObject role);
    public boolean editRole(JSONObject role);
    public boolean deleteRole(String roleName);
    public JSONObject getAll();
    public JSONObject getByCondition(JSONObject search);
    public boolean assignUserToRole(String roleName,String userName);
    public boolean deleteUserFromRole(String roleName,String userName);
    public JSONObject getListOfUsersRole(String roleName);
}
