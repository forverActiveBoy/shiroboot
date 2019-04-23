package com.alibaba.dao;
import com.alibaba.entity.Resource;
import java.util.List;
public interface ResourceDao{
	/**
	 * 获得Resource数据的总行数
	 * @return
	 */
    long getResourceRowCount();
	/**
	 * 获得Resource数据集合
	 * @return
	 */
    List<Resource> selectResource();
	/**
	 * 获得一个Resource对象,以参数Resource对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Resource selectResourceByObj(Resource obj);
	/**
	 * 通过Resource的id获得Resource对象
	 * @param id
	 * @return
	 */
    Resource selectResourceById(Integer id);
	/**
	 * 插入Resource到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertResource(Resource value);
	/**
	 * 插入Resource中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyResource(Resource value);
	/**
	 * 通过Resource的id删除Resource
	 * @param id
	 * @return
	 */
    int deleteResourceById(Integer id);
	/**
	 * 通过Resource的id更新Resource中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateResourceById(Resource enti);
	/**
	 * 通过Resource的id更新Resource中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyResourceById(Resource enti);
}