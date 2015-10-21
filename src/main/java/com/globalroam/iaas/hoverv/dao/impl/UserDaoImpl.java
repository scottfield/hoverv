package com.globalroam.iaas.hoverv.dao.impl;

import com.globalroam.iaas.hoverv.basic.impl.MybatisBaseDaoImpl;
import com.globalroam.iaas.hoverv.dao.UserDao;
import com.globalroam.iaas.hoverv.domain.Role;
import com.globalroam.iaas.hoverv.exception.DataAccessException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class description :
 * @version : 1.0
 * @date £» 15/10/20
 * @author :  guangliang
 */
@Repository("userDao")
public class UserDaoImpl extends MybatisBaseDaoImpl<Role> implements UserDao {
    @Override
    public List<Role> getRoleInfo(int userId) throws DataAccessException {
        System.out.println("in>>>>>>>>>>>>>>");
        List<Role> roleList  = sqlSession.selectList("getRoleInfo",userId);
        System.out.println("out>>>>>>>>>>>>>>");
        System.out.println(roleList);
        return roleList;
    }

    @Override
    public Integer count() {
        return sqlSession.selectOne("count");
    }
}