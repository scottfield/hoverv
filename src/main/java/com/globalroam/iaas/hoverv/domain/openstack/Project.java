/*
 * copyright :  GLOBALROAM Ptd Ltd
 *         Project.java 
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
 * Project
 *
 * @author zhangpengyangming
 * @version 1.0
 * @date 2015/10/20 0020
 */
public class Project implements Serializable {
    private String name;
    private String regionName;
    private String instanceQuantity;
    private String totalNicTrafficQuantity;
    private String totalRdWrtQuantity;
    private String userQuantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getInstanceQuantity() {
        return instanceQuantity;
    }

    public void setInstanceQuantity(String instanceQuantity) {
        this.instanceQuantity = instanceQuantity;
    }

    public String getTotalNicTrafficQuantity() {
        return totalNicTrafficQuantity;
    }

    public void setTotalNicTrafficQuantity(String totalNicTrafficQuantity) {
        this.totalNicTrafficQuantity = totalNicTrafficQuantity;
    }

    public String getTotalRdWrtQuantity() {
        return totalRdWrtQuantity;
    }

    public void setTotalRdWrtQuantity(String totalRdWrtQuantity) {
        this.totalRdWrtQuantity = totalRdWrtQuantity;
    }

    public String getUserQuantity() {
        return userQuantity;
    }

    public void setUserQuantity(String userQuantity) {
        this.userQuantity = userQuantity;
    }
}
