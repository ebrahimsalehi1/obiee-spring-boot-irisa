package com.irisa.obiee.backforfront.userprofile;

import java.util.List;

public class UserProfileServiceImpl implements UserProfileService {

    @Override
    public int add(UserProfile userProfile) {
        System.out.println("add user profile");

        return 0;
    }

    @Override
    public int edit(UserProfile userProfile) {
        System.out.println("edit user profile");

        return 0;
    }

    @Override
    public int delete(UserProfile userProfile) {
        System.out.println("delete user profile");

        return 0;
    }

    @Override
    public List<UserProfile> getAll() {
        System.out.println("getAll user profile");

        return null;
    }

    @Override
    public UserProfile findById(String user) {
        System.out.println("find by id user profile");

        return null;
    }
}
