package com.loop.web.controller;

import com.loop.web.bean.User;
import com.loop.web.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("test")
public class MyUserController {
    @Autowired
    MyUserService myUserService;

    @RequestMapping(value = "select", method = RequestMethod.GET)
    public List<User> getAllUser() {
        List<User> userList = myUserService.getAllUser();
        return userList;
    }

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    public User insertUser(User user) {
        user.setPassword("test");
        user.setUserId(UUID.randomUUID().toString());
        user.setUserSolved("test");
        user.setUserStatus("test");
        user.setUserSubmit("test");
        user.setUserCode("test");
        user.setUserEmail("test");
        user.setUsername("test");
        user.setUserNickname("test");
        user.setUserSchool("test");

        myUserService.insertUser(user);
        return user;
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public void deleteUserById(User user) {
        user.setUserId("ddd");
        myUserService.deleteUserById(user);
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public void updateUserById(User user) {
        user.setUserId("abc");
        myUserService.updateUserById(user);
    }
}
