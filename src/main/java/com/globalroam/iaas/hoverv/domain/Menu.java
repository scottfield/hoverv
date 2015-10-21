package com.globalroam.iaas.hoverv.domain;

import java.util.List;

/**
 * Class description : Menu javabean
 * @author :  guangliang
 * @version : 1.0
 * @date £» 15/10/20
 */
public class Menu {
    private String menuName;
    private Menu parentMenu;
    private List<Menu> subMenus;

    @Override
    public String toString() {
        return "Menu{" + "menuName='" + menuName + '\'' + '}';
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }
}
