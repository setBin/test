package com.loop.web.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-13
 * @time: 11:30
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tags {
    public Integer getTagsId() {
        return tagsId;
    }

    public void setTagsId(Integer tagsId) {
        this.tagsId = tagsId;
    }

    public Tags() {
    }

    private Integer tagsId;

    public String getTagsName() {
        return tagsName;
    }

    public void setTagsName(String tagsName) {
        this.tagsName = tagsName;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    private String tagsName;
    private Integer problemId;
}
