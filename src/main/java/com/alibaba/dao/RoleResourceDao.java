package com.alibaba.dao;
import com.alibaba.entity.RoleResource;
import java.util.List;
public interface RoleResourceDao{
	/**
	 * 获得RoleResource数据的总行数
	 * @return
	 */
    long getRoleResourceRowCount();
	/**
	 * 获得RoleResource数据集合
	 * @return
	 */
    List<RoleResource> selectRoleResource();
	/**
	 * 获得一个RoleResource对象,以参数RoleResource对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    RoleResource selectRoleResourceByObj(RoleResource obj);
	/**
	 * 通过RoleResource的id获得RoleResource对象
	 * @param id
	 * @return
	 */
    RoleResource selectRoleResourceById(Integer id);
	/**
	 * 插入RoleResource到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertRoleResource(RoleResource value);
	/**
	 * 插入RoleResource中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyRoleResource(RoleResource value);
	/**
	 * 通过RoleResource的id删除RoleResource
	 * @param id
	 * @return
	 */
    int deleteRoleResourceById(Integer id);
	/**
	 * 通过RoleResource的id更新RoleResource中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateRoleResourceById(RoleResource enti);
	/**
	 * 通过RoleResource的id更新RoleResource中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyRoleResourceById(RoleResource enti);

	/**
	 * @function 根据角色名字，查询该角色下所有的资源id集合
	 * @param roleName
	 */
	List<Integer> selectResIdByRoleName(String roleName);
}