package com.integralproject.integralproject.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    int id;
    String username;
    String password;
    Set<Integer> following = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Integer> getFollowing() {
        return following;
    }

    public void setFollowing(Set<Integer> following) {
        this.following = following;
    }

}
