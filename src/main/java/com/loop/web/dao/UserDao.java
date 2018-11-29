package com.loop.web.dao;

import com.loop.web.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface UserDao {

    List<User> getAllUser();
    //添加用户
    void insertUser(User user);
    //根据用户名得到用户的信息
    User getUserByUsername(String username);
    //删除用户通过用户的id
    void deleteUserById(String userId);
    //通过id查询字段
    User getUserById(String userId);
    //根据用户的id得到用户的角色id集合
    List<String> getUserRoldId(String userId);
    //取消用户的角色
    void deleteUserRole(String userId);
    //给用户分配角色
    void addUserRole(Map<String,String> map);

    void updateUserById(@Param("userId") String userId,@Param("user_submit") String user_submit);

    void updateUserinfoById(@Param("userId") String userId, @Param("user_submit") String user_submit);
}
