package com.loop.web.controller;

import com.loop.web.bean.Problem;
import com.loop.web.bean.Tags;
import com.loop.web.service.TagsService;
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
 * @date: 2018-08-13
 * @time: 16:51
 */
@RequestMapping("")
@RestController
public class TagsContrlloer {

    @Autowired
    TagsService tagsService;
    //查询出所有标签
    @RequestMapping(value = "tags",method = RequestMethod.GET)
    public Msg getAllTags(){
        List<Tags> tagsList=tagsService.getAllTags();
        return Msg.success().add("msg",tagsList);
    }
    /**
     * 根据标签名字获取题目
     */
    @RequestMapping(value = "tags/{tagsName}",method = RequestMethod.GET)
    public Msg getProListByTagsName(@PathVariable("tagsName") String tagsName){
        List<Problem> problemList=tagsService.getProListByTagsName(tagsName);
        return Msg.success().add("msg",problemList);
    }

}
