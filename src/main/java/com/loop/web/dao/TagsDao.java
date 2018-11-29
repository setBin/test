package com.loop.web.dao;

import com.loop.web.bean.Tags;

import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-13
 * @time: 11:54
 */
public interface TagsDao {

    void addTags(Map<String,Object> map);

    List<Tags> getAllTags();

    void deleteTagByProblemId(Integer problemId);

    List<Integer> getProListByTagsName(String tagsName);

}
