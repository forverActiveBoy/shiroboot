package com.alibaba.entity;
public class UserTeacher {
    private Long id;
    private Long userId;
    private Long teacherId;
    public UserTeacher() {
        super();
    }
    public UserTeacher(Long id,Long userId,Long teacherId) {
        super();
        this.id = id;
        this.userId = userId;
        this.teacherId = teacherId;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

}
