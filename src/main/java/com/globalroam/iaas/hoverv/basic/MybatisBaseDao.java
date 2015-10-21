package com.globalroam.iaas.hoverv.basic;

import java.util.List;

public interface MybatisBaseDao<T> {
	/**
	 * 插入
	 * @param role
	 * return int 返回0插入失败，返回1插入成功
	 */
	int insert(T t);
	/**
	 * 更新
	 * @param user
	 * return int返回0插入失败，返回1插入成功
	 */
	int update(T t);
	/**
	 * 根据ID删除
	 * @param id
	 * return int返回0插入失败，返回1插入成功
	 */
	int deleteById(String id);
	/**
	 * 根据ID数组，删除
	 * @param ids
	 * return int返回0插入失败，返回1插入成功
	 */
	int deleteByIds(String[] ids);
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 */
	T getById(String id);
	
	/**
	 * 获取全部
	 * @return
	 */
	List<T> getAll();
	/**
	 * 查找分页数据
	 * @param index 下标,从1开始
	 * @param pagesize 分页数
	 * @return
	 */
	List<T> getByPage(Integer index, Integer pagesize);
	
	Integer getTotalRecord();
}
