/*
 * copyright :  GLOBALROAM Ptd Ltd
 *         User.java 
 * Author:
 *         zhangpengyangming
 * Date£º
 *         2015/10/20 0020
 * Version: 
 *         1.0   
 * Revisions: 
 *         dicription
 */
package com.globalroam.iaas.hoverv.domain.openstack;

import java.io.Serializable;

/**
 * User
 *
 * @author zhangpengyangming
 * @version 1.0
 * @date 2015/10/20 0020
 */
public class User implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
