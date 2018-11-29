package com.loop.web.controller;

import com.loop.web.bean.Menu;
import com.loop.web.service.MenuService;
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
public class MenuController {
    @Autowired
    MenuService menuService;
    //添加菜单
    @RequestMapping(value = "/menu",method = RequestMethod.POST)
    public Msg addArticle(@RequestBody  @Valid Menu menu , BindingResult result)
    {
        if(menu.getMenuName()!=null && !menu.getMenuName().isEmpty())
        {
            if(result.hasErrors()) {
                //校验失败，应该返回失败，在模态框中显示校验失败的错误信息
                Map<String, Object> map = new HashMap<String, Object>();
                List<FieldError> errors = result.getFieldErrors();
                for (FieldError fieldError : errors) {
                    System.out.println("错误的字段名：" + fieldError.getField());
                    System.out.println("错误信息：" + fieldError.getDefaultMessage());
                    map.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
                return Msg.fail().add("错误的字段", map);
            }else
            {
                menu.setMenuId(CommonHelper.getId());
                menuService.addMenu(menu);
            }
            return Msg.success().add("msg","添加成功");
        }else {
            return Msg.fail().add("msg","参数错误");
        }
    }
    //更新菜单
    @RequestMapping(value = "/menu/{id}",method = RequestMethod.PUT)
    public Msg updataRole(@RequestBody @Valid Menu menu , BindingResult bindingResult, @PathVariable("id") String id){
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
            Menu menu1=menuService.getMenuById(id);
            if(menu1!=null)
            {
                menu.setMenuId(id);
                menuService.updataMenu(menu);
                return Msg.success().add("msg","更新成功");
            }
            return  Msg.fail().add("msg","不存子id");
        }

    }
}
