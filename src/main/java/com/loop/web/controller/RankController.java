package com.loop.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loop.web.bean.User;
import com.loop.web.service.UserService;
import com.loop.web.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-29
 * @time: 23:17
 */
@RestController
@RequestMapping("")
public class RankController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "rank/{curPage}/{pageSize}/{navigatePages}",method = RequestMethod.GET)
    public Msg get(@PathVariable(value = "curPage") Integer curPage,
                   @PathVariable(value = "pageSize") Integer pageSize,
                   @PathVariable(value = "navigatePages") Integer navigatePages){
        PageHelper.startPage(curPage,pageSize);
        List<User> userList= userService.getAllUserInfo();
        PageInfo pageInfo=new PageInfo(userList,navigatePages);
        return Msg.success().add("msg",pageInfo);


    }
}
