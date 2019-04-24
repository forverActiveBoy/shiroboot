package com.alibaba.dao;
import com.alibaba.entity.Role;
import java.util.List;
public interface RoleDao{
	/**
	 * 获得Role数据的总行数
	 * @return
	 */
    long getRoleRowCount();
	/**
	 * 获得Role数据集合
	 * @return
	 */
    List<Role> selectRole();
	/**
	 * 获得一个Role对象,以参数Role对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Role selectRoleByObj(Role obj);
	/**
	 * 通过Role的id获得Role对象
	 * @param id
	 * @return
	 */
    Role selectRoleById(Integer id);
	/**
	 * 插入Role到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertRole(Role value);
	/**
	 * 插入Role中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyRole(Role value);
	/**
	 * 通过Role的id删除Role
	 * @param id
	 * @return
	 */
    int deleteRoleById(Integer id);
	/**
	 * 通过Role的id更新Role中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateRoleById(Role enti);
	/**
	 * 通过Role的id更新Role中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyRoleById(Role enti);
}