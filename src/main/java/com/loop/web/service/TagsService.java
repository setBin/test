package com.loop.web.service;

import com.loop.web.bean.Problem;
import com.loop.web.bean.Tags;
import com.loop.web.dao.ProblemDao;
import com.loop.web.dao.TagsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-13
 * @time: 11:55
 */
@Service
public class TagsService {

    @Autowired
    TagsDao tagsDao;
    @Autowired
    ProblemDao problemDao;

    /**
     * 存标签
     * @param tags
     * @param problemId
     */
    public  void addTags(String[] tags, Integer problemId) {

        Map<String,Object> map= new HashMap<String, Object>();
        map.put("problemId",problemId);
        for(int i=0;i<tags.length;i++){
            System.out.println(tags[i]);
            System.out.println(problemId);
            map.put("tagName",tags[i]);
            tagsDao.addTags(map);
        }

    }

    public List<Tags> getAllTags() {
        return tagsDao.getAllTags();
    }

    public List<Problem> getProListByTagsName(String tagsName) {

        List<Integer> stringList=tagsDao.getProListByTagsName(tagsName);
        List<Problem> problemList=new ArrayList<Problem>();
        for(Integer item:stringList){
            System.out.println(item);
            Problem problem=problemDao.selectProById(item);
            problemList.add(problem);
        }
        return  problemList;

    }

    public void deleteTags(Integer problemId) {
        tagsDao.deleteTagByProblemId(problemId);
    }
}
