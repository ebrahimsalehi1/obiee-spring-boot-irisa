package com.irisa.obiee.backforfront.userprofile;

import java.util.List;

public interface UserProfileService {

    public int add(UserProfile userProfile);
    public int edit(UserProfile userProfile);
    public int delete(UserProfile userProfile);
    public List<UserProfile> getAll();
    public UserProfile findById(String user);
}
