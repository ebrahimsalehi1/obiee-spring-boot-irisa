package com.irisa.obiee.backforfront.obieeservices;

public class User {

    private String name;
    private String displayName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }

}

