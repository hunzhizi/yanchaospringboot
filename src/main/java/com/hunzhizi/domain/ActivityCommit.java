package com.hunzhizi.domain;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-04-27 17:50
 * @description:用于活动报名封装的类
 */
public class ActivityCommit {
    private Integer activityCommitId;
    private Integer userId;
    private Integer activityId;
    private String stuName;
    private String stuId;
    private Integer clazz;   //班级
    private String phoneNum;
    private String qq;
    private String stuEmail;

    public Integer getActivityCommitId() {
        return activityCommitId;
    }

    public void setActivityCommitId(Integer activityCommitId) {
        this.activityCommitId = activityCommitId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }
}
