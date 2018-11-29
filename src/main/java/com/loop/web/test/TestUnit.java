package com.loop.web.test;

import com.loop.web.service.TagsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-13
 * @time: 13:05
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-applicationContext.xml"})
public class TestUnit {

    @Autowired
    TagsService tagsService;
    @Test
    public void test(){


        tagsService.getProListByTagsName("tag1");


    }
}
