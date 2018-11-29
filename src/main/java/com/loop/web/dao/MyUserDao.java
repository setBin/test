package com.loop.web.dao;

import com.loop.web.bean.User;

import java.util.List;

public interface MyUserDao {
    public List<User> getAllUser();

    public void insertUser(User user);

    public void deleteUserById(User user);

    public void updateUserById(User user);
}
