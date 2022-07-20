package com.hunzhizi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hunzhizi.enums.UserType;

import java.util.Date;

/**
 * @author 魂之子
 * @program: springMVC
 * @create: 2022-04-12 13:08
 * @description:
 */
public class User {
    private Integer userId;
    private String nickname;
    private Integer gender;// = 0;     //0:default 1:boy 2:girl
    private Integer userType;// = UserType.VISITOR;
    private Integer reportNum;// = 0;
    private Boolean forbidden;// = false;     //是否禁用
    private Boolean recognized;// = false;    //是否认证过
    private Boolean anonymous;// = false;   //是否匿名
    private String officialName;    //官方名称
    private String bio;         //个性签名
    private Date createTime = new Date();
    private Date lastEditTime = new Date();
    private String profileAddr;     //头像所放的地址

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getReportNum() {
        return reportNum;
    }

    public void setReportNum(Integer reportNum) {
        this.reportNum = reportNum;
    }

    public Boolean getForbidden() {
        return forbidden;
    }

    public void setForbidden(Boolean forbidden) {
        this.forbidden = forbidden;
    }

    public Boolean getRecognized() {
        return recognized;
    }

    public void setRecognized(Boolean recognized) {
        this.recognized = recognized;
    }

    public Boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public String getProfileAddr() {
        return profileAddr;
    }

    public void setProfileAddr(String profileAddr) {
        this.profileAddr = profileAddr;
    }
}
