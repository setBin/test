package com.loop.web.service;

import com.loop.web.bean.User;
import com.loop.web.dao.UserDao;
import com.loop.web.utils.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    //得到所有用户的信息
    public List<User> getAllUserInfo(){
        return userDao.getAllUser();
    }

    /**
     * 保存用户信息
     * @param user
     */
    public void saveUser(User user) {
            userDao.insertUser(user);
    }

    //登录验证
    public User doLogin(String username, String password) {
        //得到当前登录对象
        Subject subject=SecurityUtils.getSubject();
        //账号密码生成凭证
        UsernamePasswordToken token =new UsernamePasswordToken(username,password);
        try {
            //设置记住我
            token.setRememberMe(true);
            //调用shiro登录函数 登录错误则跳转到AuthenticationException e
            subject.login(token);
            //获取独享的session对象
            Session session = subject.getSession();
            //通过用户名返回当前登录用户对象
            User user = this.getUserByUsername(username);
            //将当前登录对象存入session
            session.setAttribute(Constants.SESSION_USER, user);
            return user;
        }catch (AuthenticationException e){
//            e.printStackTrace();
            // 如何不存在当前对象则返回null
            return null;
        }
    }

    //根据用户名返回用户的信息
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
    //删除用户通过用户id
    public void deleteId(String ids) {
        userDao.deleteUserById(ids);

    }
    //批量删除用户通过id
    public void deleteBatch(List<String> de_ids) {
        for (String id :de_ids) {
            this.deleteId(id);
            }
        }
    //通过id查询用户信息
    public User selectUserById(String ids) {
        return userDao.getUserById(ids);
    }

    //根据用户的id得到用户的角色集合
    public List<String> getUserRoleIds(String userId) {
        return userDao.getUserRoldId(userId);
    }

    //给用户分配角色
    public void addUserRole(String userId, String[] roleIds) {
        //在给用户分配角色的 先删除用户的所有角色关联
        userDao.deleteUserRole(userId);
        Map<String,String> map=new HashMap<String,String>();
        map.put("userId",userId);
        for(String roleId:roleIds){
            map.put("roleId",roleId);
            userDao.addUserRole(map);
        }
    }

    public void updateUserById(String userId, String user_submit) {

        userDao.updateUserById(userId,user_submit);
    }

    public void updateUserinfoById(String userId, String user_submit) {
        userDao.updateUserinfoById(userId,user_submit);
    }


}

