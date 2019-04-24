package com.alibaba.entity;
public class RoleResource {
    private Integer id;
    private String rolename;
    private Integer resid;
    public RoleResource() {
        super();
    }
    public RoleResource(Integer id,String rolename,Integer resid) {
        super();
        this.id = id;
        this.rolename = rolename;
        this.resid = resid;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return this.rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Integer getResid() {
        return this.resid;
    }

    public void setResid(Integer resid) {
        this.resid = resid;
    }

}
