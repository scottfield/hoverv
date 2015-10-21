package com.globalroam.iaas.hoverv.dao;

import com.globalroam.iaas.hoverv.domain.Menu;
import com.globalroam.iaas.hoverv.exception.DataAccessException;

/**
 * Interface description : Menu interface
 * @version : 1.0 
 * @date : 15/10/20
 * @author : guangliang  
 */
public interface MenuDao {

    Menu getMenuInformation() throws DataAccessException;
}

