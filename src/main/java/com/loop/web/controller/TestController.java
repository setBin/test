package com.loop.web.controller;

import com.loop.web.bean.User;
import com.loop.web.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-12
 * @time: 23:54
 */
@RestController
public class TestController {

    @RequestMapping(value = "testMap",method = RequestMethod.POST)
    public Msg testMap(@RequestBody Map<String,String> map){


        for (String key : map.keySet()) {
            System.out.println("Key = " + key);
        }
//遍历map中的值
        for (String value : map.values()) {
            System.out.println("Value = " + value);
        }
        return Msg.success().add("info",map.size());
    }
    @RequestMapping(value = "testStringArray",method = RequestMethod.POST)
    public Msg testStringArray(@RequestBody String[] stringList){

        for (int i=0;i<stringList.length;i++) {
            System.out.println(stringList[i]);
        }
        return Msg.success().add("info",stringList.length);
    }
    @RequestMapping(value = "testList",method = RequestMethod.POST)
    public Msg testList(@RequestBody List<String> stringList){

        for (String item:stringList) {
            System.out.println(item);
        }
        return Msg.success().add("info",stringList.size());
    }
    @RequestMapping(value = "testMapList",method = RequestMethod.POST)
    public Msg testMapObject(@RequestBody Map<String,List<String>> map){
        for (String key : map.keySet()) {
            System.out.println("Key = " + key);
        }
//遍历map中的值
        for (List<String> value : map.values()) {
            for(String item:value){
                System.out.println(item);
            }
        }
        return Msg.success().add("info",map.size());
    }
    @RequestMapping(value = "testString",method = RequestMethod.POST)
    public Msg testString(@RequestBody String string){

        return Msg.success().add("info",string);
    }
    @RequestMapping(value = "testListMap",method = RequestMethod.POST)
    public Msg testString(@RequestBody List<Map<String,String>> mapList){

        for (Map map:mapList){

            for (Object key : map.keySet()) {
                System.out.println("Key = " + key);
            }
            //遍历map中的值
            for (Object value : map.values()) {
                    System.out.println(value);
            }
        }
        return Msg.success().add("info",mapList.size());
    }
}
