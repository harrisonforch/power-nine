package com.example.powernine.person;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String UID;
    private String username;
    private String password;

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
