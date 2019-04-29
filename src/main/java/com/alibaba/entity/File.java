package com.alibaba.entity;
public class File {
    private Long id;
    private String name;//文件名
    private String image;//文件存储路径
    public File() {
        super();
    }
    public File(Long id,String name,String image) {
        super();
        this.id = id;
        this.name = name;
        this.image = image;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
