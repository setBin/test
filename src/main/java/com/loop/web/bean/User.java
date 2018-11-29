package com.loop.web.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Pattern;
import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {

    private String userId;
    private String userStatus;
    private String username;
    private String password;
    private String userCode;
    @Pattern(regexp="^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",
            message="邮箱格式不正确")
    private String userEmail;
    private String userSchool;
    private String userNickname;
    private Date userCreatTime;

    //用户总的题目提交数
    private String userSubmit;
    //用户提交成功次数
    private String userSolved;

    public String getUserSubmit() {
        return userSubmit;
    }

    public void setUserSubmit(String userSubmit) {
        this.userSubmit = userSubmit;
    }

    public String getUserSolved() {
        return userSolved;
    }

    public void setUserSolved(String userSolved) {
        this.userSolved = userSolved;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public Date getUserCreatTime() {
        return userCreatTime;
    }

    public void setUserCreatTime(Date userCreatTime) {
        this.userCreatTime = userCreatTime;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userCode='" + userCode + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userSchool='" + userSchool + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userCreatTime=" + userCreatTime +
                ", userSubmit='" + userSubmit + '\'' +
                ", userSolved='" + userSolved + '\'' +
                '}';
    }
}
