package com.loop.web.controller;

import com.loop.web.bean.Menu;
import com.loop.web.bean.User;
import com.loop.web.service.MenuService;
import com.loop.web.utils.Constants;
import com.loop.web.utils.Msg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class PageController {


    @Autowired
    MenuService menuService;
    //左边的菜单栏 根据用户的角色的不同  显示不同的菜单
    @RequestMapping(value = "/sidebar",method = RequestMethod.GET)
    public Msg sideMenu(){

        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute(Constants.SESSION_USER);
        List<Menu> menus= menuService.getUserMenu(user.getUserId());
        return Msg.success().add("msg",menus);
    }
    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public Msg errorHandle(){
        return Msg.success().add("msg","大哥你越权了");
    }
}
