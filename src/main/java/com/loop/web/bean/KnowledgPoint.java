package com.loop.web.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hyh
 * Date: 2018/7/31
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class KnowledgPoint {
    private String pointId;
    private String pointRemark;
    private String pointName;

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getPointRemark() {
        return pointRemark;
    }

    public void setPointRemark(String pointRemark) {
        this.pointRemark = pointRemark;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    private String sectionId;

    public List<Problem> getProblemList() {
        return problemList;
    }

    public void setProblemList(List<Problem> problemList) {
        this.problemList = problemList;
    }

    private List<Problem> problemList;
}
