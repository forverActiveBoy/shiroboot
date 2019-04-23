package com.alibaba.entity;
public class Resource {
    private Integer id;
    private String resname;
    private String resurl;
    private String restype;
    private String rescode;
    private Integer parentId;
    public Resource() {
        super();
    }
    public Resource(Integer id,String resname,String resurl,String restype,String rescode,Integer parentId) {
        super();
        this.id = id;
        this.resname = resname;
        this.resurl = resurl;
        this.restype = restype;
        this.rescode = rescode;
        this.parentId = parentId;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResname() {
        return this.resname;
    }

    public void setResname(String resname) {
        this.resname = resname;
    }

    public String getResurl() {
        return this.resurl;
    }

    public void setResurl(String resurl) {
        this.resurl = resurl;
    }

    public String getRestype() {
        return this.restype;
    }

    public void setRestype(String restype) {
        this.restype = restype;
    }

    public String getRescode() {
        return this.rescode;
    }

    public void setRescode(String rescode) {
        this.rescode = rescode;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

}
