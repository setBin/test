package com.loop.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loop.web.bean.User;
import com.loop.web.bean.UserRole;
import com.loop.web.service.UserService;
import com.loop.web.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    UserService userService;
    //获取所有用户的信息
    @RequestMapping(value = "/user/{curPage}/{pageSize}/{navigatePages}",method = RequestMethod.GET)
    public Msg getAllUserMsg(@PathVariable(value = "curPage") Integer curPage,
                             @PathVariable(value = "pageSize") Integer pageSize,
                             @PathVariable(value = "navigatePages") Integer navigatePages){
        PageHelper.startPage(curPage,pageSize);
        List<User> users=userService.getAllUserInfo();
        PageInfo pageInfo=new PageInfo(users,navigatePages);
        return Msg.success().add("msg",pageInfo);
    }
    /**
     * 批量删除用户
     * @param ids
     * @param
     * @return
     */
    @RequestMapping(value = "/user/{ids}",method = RequestMethod.DELETE)
    public Msg deleteUserMsgByuserid(@PathVariable("ids") String ids){

        if(ids!=null && !ids.trim().isEmpty()) {
            if (ids.contains("_")) {
                List<String> de_ids = new ArrayList<String>();
                String[] str_ids = ids.split("_");
                for (String string : str_ids) {
                    de_ids.add(string);
                }
                userService.deleteBatch(de_ids);
            } else {
                userService.deleteId(ids);
            }
            return Msg.success().add("msg", "删除成功");
        }
        return Msg.fail().add("msg","参数错误");
    }
    /**
     * 通过id查询用户信息
     * @param ids
     * @return
     */
    @RequestMapping(value = "/user/{ids}",method = RequestMethod.GET)
    public Msg selectUserMsgByUserId(@PathVariable("ids") String ids){
        if(ids!=null&&!ids.isEmpty()){
            return Msg.success().add("msg",userService.selectUserById(ids));
        }else{
            return Msg.fail().add("msg","id不存在");
        }
    }
    /**
     * 根据用户的id 得到用户的角色 返回一个数组
     * @param userId
     * @return
     */
    @RequestMapping(value = "/userRole/{userId}",method = RequestMethod.GET)
    public Msg userRole(@PathVariable("userId") String userId){
        Map<String, List<String>> stringListMap=new HashMap<String, List<String>>();
        List<String> list=userService.getUserRoleIds(userId);
        stringListMap.put("roleIds",list);
        return Msg.success().add("msg",stringListMap);
    }
    /**
     * 为用户分配角色 传入用户的id和角色的id字符串
     * @return
     */
    @RequestMapping(value = "/assignRole",method = RequestMethod.POST)
    public Msg assignRole(@RequestBody UserRole userRole){

        if(userRole.getRoleIds()!=null && userRole.getUserId()!=null
                &&!userRole.getRoleIds().trim().isEmpty()&&!userRole.getRoleIds().trim().isEmpty()){
            String[] roleIds=null;
            if(userRole.getRoleIds().contains("_")) {
                roleIds = userRole.getRoleIds().split("_");
            }
            userService.addUserRole(userRole.getUserId(),roleIds);
            return Msg.success().add("msg","分配成功");
        }
        return Msg.fail().add("msg","参数错误");
    }
}
