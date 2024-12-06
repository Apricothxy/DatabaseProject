package com.wxy.databaseproject.model;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String membership;

    public User() {}

    public User(Integer id, String username, String password, String membership) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.membership = membership;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }
}
