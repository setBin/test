package com.loop.web.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Intellij IDEA.
 *
 * @author: 霍运浩
 * @date: 2018-08-29
 * @time: 9:48
 */
public class Solution {
    public Integer getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Integer solutionId) {
        this.solutionId = solutionId;
    }

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getContestId() {
        return contestId;
    }

    public void setContestId(Integer contestId) {
        this.contestId = contestId;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(Integer codeLength) {
        this.codeLength = codeLength;
    }

    public Date getJudgetime() {
        return judgetime;
    }

    public void setJudgetime(Date judgetime) {
        this.judgetime = judgetime;
    }

    public BigDecimal getPass_rate() {
        return pass_rate;
    }

    public void setPass_rate(BigDecimal pass_rate) {
        this.pass_rate = pass_rate;
    }

    public Integer getLintError() {
        return lintError;
    }

    public void setLintError(Integer lintError) {
        this.lintError = lintError;
    }

    public String getJudger() {
        return judger;
    }

    public void setJudger(String judger) {
        this.judger = judger;
    }

    private Integer solutionId;
    private Integer problemId;
    private String username;
    private Integer time;
    private Integer memory;
    private Date inDate;
    private Integer result;
    private Integer language;
    private String ip;
    private Integer contestId;
    private Integer valid;
    private Integer num;

    private Integer codeLength;
    private Date judgetime;
    private BigDecimal pass_rate;
    private  Integer lintError;
    private String judger;

    public String getResultC() {
        return resultC;
    }

    public void setResultC(String resultC) {
        this.resultC = resultC;
    }

    private String resultC;

}
