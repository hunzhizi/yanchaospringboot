package com.hunzhizi.domain;

/**
 * @ClassName CommentReply
 * TODO
 * @Date 2023/1/9 22:40
 */
public class CommentReply {
    private Integer userId;
    private String message;

    public CommentReply() {
    }

    public CommentReply(Integer userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
