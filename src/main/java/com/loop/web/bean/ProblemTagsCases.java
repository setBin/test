package com.loop.web.bean;

import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-13
 * @time: 2:15
 */
public class ProblemTagsCases {
    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
    private Problem problem;
    private String[] tags;

    public List<Map<String, String>> getStringMap() {
        return stringMap;
    }

    public void setStringMap(List<Map<String, String>> stringMap) {
        this.stringMap = stringMap;
    }

    private List<Map<String,String>> stringMap;
}
