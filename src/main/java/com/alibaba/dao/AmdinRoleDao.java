package com.alibaba.dao;
import com.alibaba.entity.AmdinRole;
import java.util.List;
public interface AmdinRoleDao{
	/**
	 * 获得AmdinRole数据的总行数
	 * @return
	 */
    long getAmdinRoleRowCount();
	/**
	 * 获得AmdinRole数据集合
	 * @return
	 */
    List<AmdinRole> selectAmdinRole();
	/**
	 * 获得一个AmdinRole对象,以参数AmdinRole对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AmdinRole selectAmdinRoleByObj(AmdinRole obj);
	/**
	 * 通过AmdinRole的id获得AmdinRole对象
	 * @param id
	 * @return
	 */
    AmdinRole selectAmdinRoleById(Integer id);
	/**
	 * 插入AmdinRole到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAmdinRole(AmdinRole value);
	/**
	 * 插入AmdinRole中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAmdinRole(AmdinRole value);
	/**
	 * 通过AmdinRole的id删除AmdinRole
	 * @param id
	 * @return
	 */
    int deleteAmdinRoleById(Integer id);
	/**
	 * 通过AmdinRole的id更新AmdinRole中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAmdinRoleById(AmdinRole enti);
	/**
	 * 通过AmdinRole的id更新AmdinRole中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAmdinRoleById(AmdinRole enti);
}