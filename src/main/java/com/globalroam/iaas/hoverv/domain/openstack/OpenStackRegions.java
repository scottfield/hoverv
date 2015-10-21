/*
 * copyright :  GLOBALROAM Ptd Ltd
 *         OpenStackRegions.java 
 * Author:
 *         zhangpengyangming
 * Date£º
 *         2015/10/20 0020
 * Version: 
 *         1.0   
 * Revisions: 
 *         beans related on OpenStack
 */
package com.globalroam.iaas.hoverv.domain.openstack;

import java.io.Serializable;
import java.util.List;

/**
 * OpenStackRegions
 *
 * @author zhangpengyangming
 * @version 1.0
 * @date 2015/10/20 0020
 */
public class OpenStackRegions implements Serializable {

    private List<Region> regions;
    private List<Project> projects;
    private List<User> users;
    private List<Instance> instances;

    public OpenStackRegions() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Instance> getInstances() {
        return instances;
    }

    public void setInstances(List<Instance> instances) {
        this.instances = instances;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
