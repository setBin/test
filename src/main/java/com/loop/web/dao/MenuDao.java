package com.loop.web.dao;

import com.loop.web.bean.Menu;
import com.loop.web.bean.MenuPermission;

import java.util.List;

public interface MenuDao {

    List<Menu> getAllMenu();

    List<MenuPermission> getMenuPerms();

    Menu getMenuById(String id);

    void updateMenu(Menu menu);

    void addMenu(Menu menu);
    //得到用户的菜单
    List<Menu> getUserMenu(String userId);
}
