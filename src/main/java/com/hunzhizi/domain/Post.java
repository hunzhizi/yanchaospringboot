package com.hunzhizi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-04-27 17:07
 * @description: 帖子实体
 */
public class Post {
    private Integer postId;
    private Integer userId;
    private Integer upNum;//= 0;      //点赞
    private Integer collectionNum;// = 0;  //收藏数量
    private Integer commentNum;// = 0;     //评论数量
    private Integer reportNum;// = 0;      //举报数量
    private String Content;     //内容
    //    private List<Comment> comments;
    private Date createTime = new Date();
    private Date lastEditTime = new Date();
    private Integer postType;// = 0;
    private List<String> imgAddrList;   //存放img的url
    private int priority;// = 0;       //根据返回值算出来的一个值，所以，应该放在dto里面
    private Integer parentZhiHu;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUpNum() {
        return upNum;
    }

    public void setUpNum(Integer upNum) {
        this.upNum = upNum;
    }

    public Integer getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(Integer collectionNum) {
        this.collectionNum = collectionNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getReportNum() {
        return reportNum;
    }

    public void setReportNum(Integer reportNum) {
        this.reportNum = reportNum;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
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

    public Integer getPostType() {
        return postType;
    }

    public void setPostType(Integer postType) {
        this.postType = postType;
    }

    public List<String> getImgAddrList() {
        return imgAddrList;
    }

    public void setImgAddrList(List<String> imgAddrList) {
        this.imgAddrList = imgAddrList;
    }

    public int getPriority() {
        return priority;
    }

    /**
     * upNum : collectionNum : CommentNum = 1 : 3 : 14
     */
    public void setPriority() {
        this.priority = upNum + 3 * collectionNum + 14 * commentNum
                - (int) ((new Date().getTime() - createTime.getTime()) / 1000 / 60/ 60 / 24);
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Integer getParentZhiHu() {
        return parentZhiHu;
    }

    public void setParentZhiHu(Integer parentZhiHu) {
        this.parentZhiHu = parentZhiHu;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", upNum=" + upNum +
                ", collectionNum=" + collectionNum +
                ", commentNum=" + commentNum +
                ", reportNum=" + reportNum +
                ", Content='" + Content + '\'' +
                ", createTime=" + createTime +
                ", lastEditTime=" + lastEditTime +
                ", postType=" + postType +
                ", imgAddrList=" + imgAddrList +
                ", priority=" + priority +
                ", parentZhiHu=" + parentZhiHu +
                '}';
    }
}
