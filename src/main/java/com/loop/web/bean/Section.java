package com.loop.web.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hyh
 * Date: 2018/7/31
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Section {
    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionRemark() {
        return sectionRemark;
    }

    public void setSectionRemark(String sectionRemark) {
        this.sectionRemark = sectionRemark;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String sectionId;
    private String sectionRemark;
    private String sectionName;
    private String userId;
    private List<KnowledgPoint> knowledgPointList;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<KnowledgPoint> getKnowledgPointList() {
        return knowledgPointList;
    }

    public void setKnowledgPointList(List<KnowledgPoint> knowledgPointList) {
        this.knowledgPointList = knowledgPointList;
    }


}
