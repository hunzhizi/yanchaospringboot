package com.hunzhizi.domain;

/**
 * @author 魂之子
 * @since 2022-06-03 20:04
 * program: yanchaospringboot
 * description:
 */
public class PostImg {

    private Integer postId;
    private String imgName;


    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    @Override
    public String toString() {
        return "PostImg{" +
                "postId=" + postId +
                ", imgName='" + imgName + '\'' +
                '}';
    }
}
