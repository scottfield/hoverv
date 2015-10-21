package com.globalroam.iaas.hoverv.domain;

/**
 * Class description :
 * @version : 1.0
 * @date £» 15/10/20
 * @author :  guangliang
 */
public class Role {

    private int roleId;
    private String roleName;
    private int parentId;
    private int level;
    private int isActive;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}