package com.loop.web.service;

import com.loop.web.bean.Role;
import com.loop.web.dao.RoleDao;
import com.loop.web.fifter.MyShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;
    @Autowired
    MyShiroFilterFactoryBean myShiroFilterFactoryBean;
    //得到所有角色信息
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
    //添加一个角色
    public void addRoles(Role role) {
        roleDao.insertRole(role);
    }
    //通过角色的id得到角色
    public Role getRoleById(String id) {
        return roleDao.getRoleById(id);
    }
    //更新角色
    public void updataRole(Role role) {
        roleDao.updateRole(role);
    }
    //通过角色的id得到角色的菜单数组
    public List<String> getRoleMenuIds(String id) {
        return roleDao.getRoleMenuIds(id);

    }

    //传入角色的id  和菜单的id数组
    public void addRoleMenu(String roleId, String[] menuIds) {
        //同样的套路  删除角色的所属的所有菜单
        roleDao.deleteRoleMenu(roleId);
        Map<String, String> param = new HashMap<String, String>();
        param.put("roleId", roleId);
        for (String menuId : menuIds) {
            param.put("menuId", menuId);
            roleDao.addRoleMenu(param);
        }
//        调用过滤工厂的方法 进行权限的更新
        myShiroFilterFactoryBean.update();
    }
}
