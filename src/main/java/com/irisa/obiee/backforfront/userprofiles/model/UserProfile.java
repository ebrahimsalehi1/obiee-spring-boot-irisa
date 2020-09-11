package com.irisa.obiee.backforfront.userprofiles.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FND_USER_PROFILES")
public class UserProfile {
    @Id
    @Column(name = "DES_KEY_USRPL",columnDefinition = "VARCHAR2(100 CHAR)")
    private String key;

    @Column(name = "LKP_TYP_USRPL",columnDefinition = "VARCHAR2(30 CHAR) NOT NULL")
    private String type;

    @Column(name = "DES_VAL_USRPL",columnDefinition = "CLOB NOT NULL")
    private String value;

    public UserProfile() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

