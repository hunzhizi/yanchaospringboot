package com.hunzhizi.domain;

/**
 * @ClassName CommentReply
 * TODO
 * @Date 2023/1/9 22:40
 */
public class CommentReply {
    private Integer postId;
    private String message;

    public CommentReply() {
    }

    public CommentReply(Integer postId, String message) {
        this.postId = postId;
        this.message = message;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
