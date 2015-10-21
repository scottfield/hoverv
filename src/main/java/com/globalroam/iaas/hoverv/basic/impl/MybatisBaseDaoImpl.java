package com.globalroam.iaas.hoverv.basic.impl;

import com.globalroam.iaas.hoverv.basic.MybatisBaseDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MybatisBaseDaoImpl<T> implements MybatisBaseDao<T> {
	/**
	 * Logger for this class
	 */
	private final Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	protected SqlSession sqlSession;
	protected String className = this.getClass().getName() + ".";
	@Override
	public int insert(T t) {
		if (logger.isDebugEnabled()) {
			logger.debug("insert() - ------- [start] -------");
		}
		
		String intactName = className + "insert";
		int result = sqlSession.insert(intactName, t) > 0?1:0;

		if (logger.isDebugEnabled()) {
			logger.debug("insert() - ------- [end] -------");
		}
		return result ;
	}

	@Override
	public int update(T t) {
		if (logger.isDebugEnabled()) {
			logger.debug("update() - ------- [start] -------");
		}

		String intactName = className + "update";
		int r = sqlSession.update(intactName, t);
		int result = r > 0?1:0;
		
		if (logger.isDebugEnabled()) {
			logger.debug("update() - ------- [end] -------");
		}
		return result;
	}

	@Override
	public int deleteById(String id) {
		if (logger.isDebugEnabled()) {
			logger.debug("deleteById() - ------- [start] -------");
		}

		String intactName = className + "deleteById";
		int result = sqlSession.delete(intactName, id) > 0?1:0;

		if (logger.isDebugEnabled()) {
			logger.debug("deleteById() - ------- [end] -------");
		}
		return result;
	}

	@Override
	public int deleteByIds(String[] ids) {
		if (logger.isDebugEnabled()) {
			logger.debug("deleteByIds() - ------- [start] -------");
		}

		String intactName = className + "deleteByIds";
		int result = sqlSession.delete(intactName, ids) > 0?1:0;

		if (logger.isDebugEnabled()) {
			logger.debug("deleteByIds() - ------- [end] -------");
		}
		return result;
	}

	@Override
	public T getById(String id) {
		if (logger.isDebugEnabled()) {
			logger.debug("getById() - ------- [start] -------");
		}

		String intactName = className + "getById";
		T t = sqlSession.selectOne(intactName, id);

		if (logger.isDebugEnabled()) {
			logger.debug("getById() - ------- [end] -------");
		}
		return t;
	}

	@Override
	public List<T> getAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - ------- [start] -------");
		}

		String intactName = className + "getAll";
		List<T> list = sqlSession.selectList(intactName);

		if (logger.isDebugEnabled()) {
			logger.debug("getAll() - ------- [end] -------");
		}
		return list;
	}

	@Override
	public List<T> getByPage(Integer index, Integer pagesize) {
		if (logger.isDebugEnabled()) {
			logger.debug("getByPage() - ------- [start] -------");
		}

		String intactName = className + "getByPage";
		Map<String,Integer> map = new HashMap<String,Integer>();
		index = index >0? index:0;
		map.put("index", index);
		map.put("pagesize", pagesize);
		List<T> list = sqlSession.selectList(intactName,map);

		if (logger.isDebugEnabled()) {
			logger.debug("getByPage() - ------- [end] -------");
		}
		return list;
	}

	@Override
	public Integer getTotalRecord() {
		if (logger.isDebugEnabled()) {
			logger.debug("getTotalRecord() - ------- [start] -------");
		}

		String intactName = className + "getTotalRecord";
		Integer record = sqlSession.selectOne(intactName);

		if (logger.isDebugEnabled()) {
			logger.debug("getTotalRecord() - ------- [end] -------");
		}
		return record;
	}

}
