package com.loop.web.controller;

import com.loop.web.bean.Menu;
import com.loop.web.bean.Role;
import com.loop.web.bean.RoleMenu;
import com.loop.web.service.MenuService;
import com.loop.web.service.RoleService;
import com.loop.web.utils.CommonHelper;
import com.loop.web.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    /**
     * 得到所有角色
     * @return
     */
    @RequestMapping(value = "/allRoles",method = RequestMethod.GET)
    public Msg getAllRoles(){
        return Msg.success().add("msg",roleService.getAllRoles());
    }
    /**
     * 添加一个角色
     * @param role
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/role",method = RequestMethod.POST)
    public Msg addRole(@RequestBody @Valid Role role , BindingResult bindingResult){
        if(role.getRoleName()!=null && !role.getRoleName().isEmpty() ){
            if(bindingResult.hasErrors()){
                Map<String,Object> map=new HashMap<String,Object>();
                List<FieldError> errors=bindingResult.getFieldErrors();
                for (FieldError fieldError:errors){
                    map.put(fieldError.getField(),fieldError.getDefaultMessage());
                }
                return Msg.fail().add("fieldMsg",map);
            }else{
                role.setRoleId(CommonHelper.getId());

                roleService.addRoles(role);
                return Msg.success().add("msg","添加成功");
            }
        }else{
            return Msg.fail().add("msg","参数错误");
        }
    }
    /**
     * 通过id获取角色
     * @param id
     * @return
     */
    @RequestMapping(value = "/role/{id}",method = RequestMethod.GET)
    public Msg getRoleById(@PathVariable("id") String id){
        Role role=roleService.getRoleById(id);
        return Msg.success().add("msg", role);
    }
    //更新角色
    @RequestMapping(value = "/role/{id}",method = RequestMethod.PUT)
    public Msg updataRole(@RequestBody @Valid Role role ,BindingResult bindingResult,@PathVariable("id") String id){
        if(bindingResult.hasErrors()) {
            //校验失败，应该返回失败，在模态框中显示校验失败的错误信息
            Map<String, Object> map = new HashMap<String, Object>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误的字段名：" + fieldError.getField());
                System.out.println("错误信息：" + fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("错误的字段", map);
        }else
        {
            Role role1=roleService.getRoleById(id);
            if(role1!=null)
            {
                role.setRoleId(id);
                roleService.updataRole(role);
                return Msg.success().add("msg","更新成功");
            }
            return  Msg.success().add("msg","不存子id");
        }

    }
    //    通过角色的id得到角色对应的的菜单id数组
    @RequestMapping(value = "roleMenu/{id}",method = RequestMethod.GET)
    public Msg roleMenu(@PathVariable("id") String id){
        List<String> list=roleService.getRoleMenuIds(id);
        return Msg.success().add("msg",list);
    }
    //    为角色分配菜单 传入角色的id  和菜单的ids数组
    @RequestMapping(value = "/assignMenu",method = RequestMethod.POST)
    public Msg assignMenu(@RequestBody @Valid RoleMenu roleMenu) {
        String[] menuIds=null;
        if(!roleMenu.getMenuIds().contains("_")){
            roleMenu.setMenuIds(roleMenu.getMenuIds()+"_");
        }
        if(roleMenu.getMenuIds().contains("_")) {
            menuIds = roleMenu.getMenuIds().split("_");
        }
        roleService.addRoleMenu(roleMenu.getRoleId(), menuIds);
        return Msg.success().add("msg","分配成功");
    }
    //    得到树形菜单
    @RequestMapping(value = "/mengList",method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> menuList() {
        return menuService.getTreeMenu();
    }
}
