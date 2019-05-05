package com.alibaba.dao;
import com.alibaba.entity.UserTeacher;
import java.util.List;
public interface UserTeacherDao{
	/**
	 * 获得UserTeacher数据的总行数
	 * @return
	 */
    long getUserTeacherRowCount();
	/**
	 * 获得UserTeacher数据集合
	 * @return
	 */
    List<UserTeacher> selectUserTeacher();
	/**
	 * 获得一个UserTeacher对象,以参数UserTeacher对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    UserTeacher selectUserTeacherByObj(UserTeacher obj);
	/**
	 * 通过UserTeacher的id获得UserTeacher对象
	 * @param id
	 * @return
	 */
    UserTeacher selectUserTeacherById(Long id);
	/**
	 * 插入UserTeacher到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertUserTeacher(UserTeacher value);
	/**
	 * 插入UserTeacher中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyUserTeacher(UserTeacher value);
	/**
	 * 通过UserTeacher的id删除UserTeacher
	 * @param id
	 * @return
	 */
    int deleteUserTeacherById(Long id);
	/**
	 * 通过UserTeacher的id更新UserTeacher中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateUserTeacherById(UserTeacher enti);
	/**
	 * 通过UserTeacher的id更新UserTeacher中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyUserTeacherById(UserTeacher enti);
}