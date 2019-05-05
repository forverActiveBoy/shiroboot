package com.alibaba.service.impl;
import java.util.List;
import com.alibaba.dao.UserDao;
import com.alibaba.dao.UserTeacherDao;
import com.alibaba.entity.User;
import com.alibaba.entity.UserTeacher;
import com.alibaba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserTeacherDao userTeacherDao;
    @Override
    public long getUserRowCount(){
        return userDao.getUserRowCount();
    }
    @Override
    public List<User> selectUser(){
        return userDao.selectUser();
    }
    @Override
    public User selectUserByObj(User obj){
        return userDao.selectUserByObj(obj);
    }
    @Override
    public User selectUserById(Long id){
        return userDao.selectUserById(id);
    }
    @Override
    public Long insertUser(User value){
        //  添加到用户表
        Long i1= userDao.insertUser(value);
        //  获取刚才添加到用户表的数据的id值
        Long userId = value.getId();
        UserTeacher userTeacher = new UserTeacher();
        userTeacher.setUserId(userId);
        int i = userTeacherDao.insertUserTeacher(userTeacher);
        return null;
    }
    @Override
    public int insertNonEmptyUser(User value){
        return userDao.insertNonEmptyUser(value);
    }
    @Override
    public int deleteUserById(Long id){
        return userDao.deleteUserById(id);
    }
    @Override
    public int updateUserById(User enti){
        return userDao.updateUserById(enti);
    }
    @Override
    public int updateNonEmptyUserById(User enti){
        return userDao.updateNonEmptyUserById(enti);
    }

    public UserDao getUserDao() {
        return this.userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}