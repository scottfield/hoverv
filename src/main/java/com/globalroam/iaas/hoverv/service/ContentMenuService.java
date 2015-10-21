package com.globalroam.iaas.hoverv.service;

import com.globalroam.iaas.hoverv.domain.Menu;

/**
 * service API for access content menu
 * Created by chenglong on 2015/10/20.
 */
public interface ContentMenuService {
    /**
     * retrieve the content menu
     * @return an menu object stand for the content menu
     */
    Menu getContentMenu();
}
