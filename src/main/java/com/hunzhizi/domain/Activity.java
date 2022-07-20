package com.hunzhizi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-04-27 17:40
 * @description: 活动只能由认证者发起，而且必须实名
 * 允许修改和删除活动
 */
public class Activity {
    private Integer activityId; //活动主键，自增
    private Integer userId;
    private Date createTime = new Date();
    private String title;   //活动标题
    private Integer participateNum;
    private String activityDesc;//活动描述
    private String submitEmail;   //活动结束后提交的邮箱
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;  //活动的截至时间
    private boolean over;  //用于表示活动是否截至
    private boolean stuName;
    private boolean stuId;
    private boolean clazz;   //班级
    private boolean phoneNum;
    private boolean qq;
    private boolean stuEmail;
//    private boolean note;    //备注默认存在


    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getParticipateNum() {
        return participateNum;
    }

    public void setParticipateNum(Integer participateNum) {
        this.participateNum = participateNum;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public String getSubmitEmail() {
        return submitEmail;
    }

    public void setSubmitEmail(String submitEmail) {
        this.submitEmail = submitEmail;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public boolean isStuName() {
        return stuName;
    }

    public void setStuName(boolean stuName) {
        this.stuName = stuName;
    }

    public boolean isStuId() {
        return stuId;
    }

    public void setStuId(boolean stuId) {
        this.stuId = stuId;
    }

    public boolean isClazz() {
        return clazz;
    }

    public void setClazz(boolean clazz) {
        this.clazz = clazz;
    }

    public boolean isPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(boolean phoneNum) {
        this.phoneNum = phoneNum;
    }

    public boolean isQq() {
        return qq;
    }

    public void setQq(boolean qq) {
        this.qq = qq;
    }

    public boolean isStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(boolean stuEmail) {
        this.stuEmail = stuEmail;
    }
}
