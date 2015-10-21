package com.globalroam.iaas.hoverv.dao;

import com.globalroam.iaas.hoverv.basic.MybatisBaseDao;
import com.globalroam.iaas.hoverv.domain.Role;
import com.globalroam.iaas.hoverv.exception.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface description : 
 * @version : 1.0 
 * @date : 15/10/20
 * @author : guangliang  
 */
public interface UserDao extends MybatisBaseDao<Role> {

    List<Role> getRoleInfo(int userId) throws DataAccessException;
    Integer count();
}