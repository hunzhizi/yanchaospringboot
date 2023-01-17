package com.hunzhizi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-04-28 09:55
 * @description:校园知乎的问题板块
 */
public class ZhiHuQuestion {
    private Integer zhiHuQuestionId;
    private Integer userId;
    private Integer priority; //热度
    private Integer upNum;
    private Integer reportNum; //举报
    private Integer commentNum;// = 0;     //评论数量
    private Date createTime = new Date();
    private Date lastEditTime = new Date();
    private String questionContent;
//    private List<Post> answers;

    public Integer getZhiHuQuestionId() {
        return zhiHuQuestionId;
    }

    public void setZhiHuQuestionId(Integer zhiHuQuestionId) {
        this.zhiHuQuestionId = zhiHuQuestionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
        //TODO 完成热度逻辑
    }

    public Integer getUpNum() {
        return upNum;
    }

    public void setUpNum(Integer upNum) {
        this.upNum = upNum;
    }

    public Integer getReportNum() {
        return reportNum;
    }

    public void setReportNum(Integer reportNum) {
        this.reportNum = reportNum;
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

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }
}
