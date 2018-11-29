package com.loop.web.controller;

import com.loop.web.bean.User;
import com.loop.web.service.UserService;
import com.loop.web.utils.CommonHelper;
import com.loop.web.utils.MD5Util;
import com.loop.web.utils.Msg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class LoginController {

    @Autowired
    UserService userService;
    //用户注册
    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public Msg signup(@Valid @RequestBody  User user, BindingResult bindingResult) throws Exception {
        if(user.getUserEmail()!=null && !user.getUserEmail().isEmpty() &&
                user.getUsername()!= null && !user.getUsername().isEmpty()&&
                user.getPassword()!= null && !user.getPassword().isEmpty()){
            if(bindingResult.hasErrors()){
                Map<String, Object> map = new HashMap<String, Object>();
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError fieldError : errors) {
                    System.out.println("错误的字段名：" + fieldError.getField());
                    System.out.println("错误信息：" + fieldError.getDefaultMessage());
                    map.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
                return Msg.success().add("msg", map);

            }else{

                user.setPassword(MD5Util.md5Encode(user.getPassword()));
                user.setUserId(CommonHelper.getId());
                user.setUserSolved("O");
                user.setUserSubmit("0");
                user.setUserCreatTime(new Date());
                user.setUserStatus("1");
                userService.saveUser(user);
                return Msg.success().add("msg","注册成功");
            }
        }else{
            return Msg.fail().add("msg","参数错误");
        }

    }
    //用户登录
    @ResponseBody
    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public Msg signin(@RequestBody User user) throws Exception {
        //得到当前的登录
        User user1=userService.doLogin(user.getUsername(),MD5Util.md5Encode(user.getPassword()));
        if(user1== null){
            return Msg.fail().add("msg","用户名或者密码错误");
        }
        return Msg.success().add("msg","登录成功");
    }
    //用户退出
    @RequestMapping(value = "/loginout",method = RequestMethod.GET)
    public Msg loginout(){
        //普通退出
//        httpSession.removeAttribute("user");
        //shiro 版退出
        //得到当前的登录对象
        Subject subject = SecurityUtils.getSubject();
        //退出当前的登录对象
        subject.logout();
        return Msg.success().add("msg","用户退出");
    }

}
