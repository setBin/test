package com.loop.web.dao;

import com.loop.web.bean.Role;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    //得到所有的角色信息
    List<Role> getAllRoles();
    //添加一个角色
    void insertRole(Role role);
    //通过用户的id得到用户的角色
    Role getRoleById(String id);
    //更新用户的角色
    void updateRole(Role role);
    //通过角色的id得到菜单id
    List<String> getRoleMenuIds(String id);
    //删除角色关联的菜单
    void deleteRoleMenu(String roleId);
    //为角色分配权限
    void addRoleMenu(Map param);


}