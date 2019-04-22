package com.alibaba.service;

import com.alibaba.entity.Admin;

import java.util.List;

public interface AdminService {
	/**
	 * 获得Admin数据的总行数
	 * @return
	 */
    long getAdminRowCount();
	/**
	 * 获得Admin数据集合
	 * @return
	 */
    List<Admin> selectAdmin();
	/**
	 * 获得一个Admin对象,以参数Admin对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Admin selectAdminByObj(Admin obj);
	/**
	 * 通过Admin的id获得Admin对象
	 * @param id
	 * @return
	 */
    Admin selectAdminById(String id);
	/**
	 * 插入Admin到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAdmin(Admin value);
	/**
	 * 插入Admin中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAdmin(Admin value);
	/**
	 * 通过Admin的id删除Admin
	 * @param id
	 * @return
	 */
    int deleteAdminById(String id);
	/**
	 * 通过Admin的id更新Admin中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAdminById(Admin enti);
	/**
	 * 通过Admin的id更新Admin中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAdminById(Admin enti);
}