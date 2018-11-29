package com.loop.web.service;

import com.loop.web.bean.User;
import com.loop.web.dao.MyUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserService {

    @Autowired
    MyUserDao myUserDao;

    public List<User> getAllUser() {
        return myUserDao.getAllUser();
    }

    public void insertUser(User user) {
        myUserDao.insertUser(user);
    }

    public void deleteUserById(User user) {
        myUserDao.deleteUserById(user);
    }

    public void updateUserById(User user) {
        myUserDao.updateUserById(user);
    }
}
