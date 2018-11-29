package com.loop.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loop.web.bean.Log;
import com.loop.web.service.LogService;
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
 * @date: 2018-08-31
 * @time: 23:54
 */
@RestController
@RequestMapping("")
public class LogController {


    @Autowired
    LogService logService;
    @RequestMapping(value = "log/{curPage}/{pageSize}/{navigatePages}",method = RequestMethod.GET)
    public Msg getAllLog(@PathVariable(value = "curPage") Integer curPage,
                         @PathVariable(value = "pageSize") Integer pageSize,
                         @PathVariable(value = "navigatePages") Integer navigatePages){
        PageHelper.startPage(curPage,pageSize);
        List<Log> logList=logService.getAllLog();
        PageInfo pageInfo=new PageInfo(logList,navigatePages);
        return Msg.success().add("msg",pageInfo);
    }
}
