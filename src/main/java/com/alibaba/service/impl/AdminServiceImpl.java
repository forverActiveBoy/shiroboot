package com.alibaba.service.impl;

import com.alibaba.dao.AdminDao;
import com.alibaba.entity.Admin;
import com.alibaba.service.AdminService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    //  采用shiro注解授权
    @RequiresPermissions({"admin:select"})
    @Override
    public long getAdminRowCount(){
        return adminDao.getAdminRowCount();
    }
    @Override
    public List<Admin> selectAdmin(){
        return adminDao.selectAdmin();
    }
    @Override
    public Admin selectAdminByObj(Admin obj){
        return adminDao.selectAdminByObj(obj);
    }
    @Override
    public Admin selectAdminById(String id){
        return adminDao.selectAdminById(id);
    }
    @Override
    public int insertAdmin(Admin value){
        return adminDao.insertAdmin(value);
    }
    @Override
    public int insertNonEmptyAdmin(Admin value){
        return adminDao.insertNonEmptyAdmin(value);
    }
    @Override
    public int deleteAdminById(String id){
        return adminDao.deleteAdminById(id);
    }
    @Override
    public int updateAdminById(Admin enti){
        return adminDao.updateAdminById(enti);
    }
    @Override
    public int updateNonEmptyAdminById(Admin enti){
        return adminDao.updateNonEmptyAdminById(enti);
    }

    public AdminDao getAdminDao() {
        return this.adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

}