package com.globalroam.iaas.hoverv.service.impl;

import com.globalroam.iaas.hoverv.dao.MenuDao;
import com.globalroam.iaas.hoverv.domain.Menu;
import com.globalroam.iaas.hoverv.service.ContentMenuService;
import org.springframework.stereotype.Service;

/**
 * the implementation of content menu service API
 * Created by chenglong on 2015/10/20.
 */
@Service
public class ContentMenuServiceImpl implements ContentMenuService {
    //TODO use menu dao implementation to get menu data
//    @Resource
    private MenuDao menuDao;

    @Override
    public Menu getContentMenu() {
        return menuDao.getMenuInformation();
    }
}
