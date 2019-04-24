package com.alibaba.entity;
public class AmdinRole {
    private Integer id;
    private String username;
    private Integer roleid;
    public AmdinRole() {
        super();
    }
    public AmdinRole(Integer id,String username,Integer roleid) {
        super();
        this.id = id;
        this.username = username;
        this.roleid = roleid;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRoleid() {
        return this.roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

}
