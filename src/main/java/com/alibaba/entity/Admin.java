package com.alibaba.entity;
public class Admin {
    private String id;
    private String username;
    private String password;
    private String beforepassword;
    private String passwordsalt;
    public Admin() {
        super();
    }
    public Admin(String id, String username, String password, String beforepassword, String passwordsalt) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.beforepassword = beforepassword;
        this.passwordsalt = passwordsalt;
    }
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBeforepassword() {
        return this.beforepassword;
    }

    public void setBeforepassword(String beforepassword) {
        this.beforepassword = beforepassword;
    }

    public String getPasswordsalt() {
        return this.passwordsalt;
    }

    public void setPasswordsalt(String passwordsalt) {
        this.passwordsalt = passwordsalt;
    }

}
