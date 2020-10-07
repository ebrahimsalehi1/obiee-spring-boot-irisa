package com.irisa.obiee.backforfront.userprofile;

import javax.persistence.*;

@Entity
@Table(name = "FND_USER_PROFILES")
public class UserProfile {
    @Id
    @Column(name = "DES_USER_USRPR",length = 100)
    private String user;

    @Column(name="DES_USER_INFO_USRPR",length = 1000)
    private String userInfo;

    public UserProfile() {
    }

    public UserProfile(String user, String userInfo) {
        this.user = user;
        this.userInfo = userInfo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
